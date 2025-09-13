package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.DTO.DemanderJobDto;
import com.projetintegration.projetintegration.DTO.JobDto;
import com.projetintegration.projetintegration.DTO.PostuleDTO;
import com.projetintegration.projetintegration.DTO.PostulerDTO;
import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.postuler;
import com.projetintegration.projetintegration.repository.AnnonceRepository;
import com.projetintegration.projetintegration.repository.PostulerRepository;
import com.projetintegration.projetintegration.service.EmailService;
import com.projetintegration.projetintegration.service.PostulerService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/PostulerAct")
public class PostulerController {
    @Autowired
    private PostulerService postulerService;
    @Autowired
    private PostulerRepository postulerRepository;
    @Autowired
    private AnnonceRepository  annonceRepository;
    @Autowired
    private EmailService emailService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/postuler")
    public ResponseEntity<?> PostulerDemande(@RequestBody PostulerDTO postuler){
        String reponse=postulerService.PostulerDemande(postuler);
        if(reponse.equals("oui")){
            return ResponseEntity.ok("");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/liste/{id}")
    public List<PostuleDTO> liste(@PathVariable Long id){
        return postulerService.getAll(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostulation(@PathVariable Long id) {
        Optional<postuler> postulation = postulerRepository.findById(id);

        if (postulation.isPresent()) {
            postulerRepository.deleteById(id);
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Postulation non trouvée");
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/accepter/{id}")
    public ResponseEntity<?> accepter(@PathVariable Long id) throws MessagingException {
        Optional<postuler> postulationOpt = postulerRepository.findByIdpostuler(id);
        if(postulationOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        postuler postulation = postulationOpt.get();
        postulation.setStatus("acceptée !");
        emailService.sendEmail(postulation.getUtilisateur().getEmail(),"Demande de poste "+postulation.getAnnonce().getNomannonce(),"votre demande de "+postulation.getAnnonce().getNomannonce()+"en lentreprise "+postulation.getAnnonce().getSociete().getNom()+"a ete acceptée ! vous devez attender pour linterview ");
        postulerRepository.save(postulation);
        return ResponseEntity.ok("");
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/refuser/{id}")
    public ResponseEntity<?> refuser(@PathVariable Long id) throws MessagingException {
        Optional<postuler> postulationOpt = postulerRepository.findByIdpostuler(id);
        if(postulationOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        postuler postulation = postulationOpt.get();
        postulation.setStatus("refusé");
        emailService.sendEmail(postulation.getUtilisateur().getEmail(),"Demande de poste "+postulation.getAnnonce().getNomannonce(),"Désole de vous dire que votre demande de "+postulation.getAnnonce().getNomannonce()+"en lentreprise "+postulation.getAnnonce().getSociete().getNom()+" a été refusé");
        postulerRepository.save(postulation);
        return ResponseEntity.ok("");
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/interview/{id}")
    public ResponseEntity<?> interview(@PathVariable Long id) throws MessagingException {
        Optional<postuler> postulationOpt = postulerRepository.findByIdpostuler(id);
        if(postulationOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        postuler postulation = postulationOpt.get();
        postulation.setStatus("invité a linterview");
        emailService.sendEmail(postulation.getUtilisateur().getEmail(),"Demande de poste "+postulation.getAnnonce().getNomannonce(),"Pour votre demande de "+postulation.getAnnonce().getNomannonce()+"en lentreprise "+postulation.getAnnonce().getSociete().getNom()+" Nous vous invite a contacter notre administrateur pour fixer un date de l'interview ! et merci");
        postulerRepository.save(postulation);
        return ResponseEntity.ok("");
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/exist/{userId}/{jobId}")
    public boolean hasUserAlreadyApplied(@PathVariable Long userId, @PathVariable Long jobId) {
        return postulerRepository.existsByUtilisateur_IdAndAnnonce_Idannonce(userId, jobId);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/postul/{jobId}")
    public List<DemanderJobDto> postul(@PathVariable Long jobId) {
        Optional<Annonce> annonce= annonceRepository.findById(jobId);
        List<postuler> posts = postulerRepository.findAllByAnnonce(annonce);
        List<DemanderJobDto> jobDtoList = new ArrayList<>();

        for (postuler post : posts) {
            JobDto dto = new JobDto();
            DemanderJobDto demanderJobDto = new DemanderJobDto();
            demanderJobDto.setId_postuler(post.getId_postuler());
            demanderJobDto.setCv(post.getCvurl());
            demanderJobDto.setLettre(post.getLettreurl());
            demanderJobDto.setNom(post.getUtilisateur().getNom());
            demanderJobDto.setPrenom(post.getUtilisateur().getPrenom());
            demanderJobDto.setStatut(post.getStatus());

            jobDtoList.add(demanderJobDto);
        }

        return jobDtoList;
    }
}
