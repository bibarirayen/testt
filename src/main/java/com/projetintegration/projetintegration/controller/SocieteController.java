package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.DTO.LoginDTO;
import com.projetintegration.projetintegration.DTO.LoginResponseDTO;
import com.projetintegration.projetintegration.DTO.SocieteDTO;
import com.projetintegration.projetintegration.entity.DemandeSociete;
import com.projetintegration.projetintegration.entity.societe;
import com.projetintegration.projetintegration.repository.DemandeSocieteRepository;
import com.projetintegration.projetintegration.repository.SocieteRepository;
import com.projetintegration.projetintegration.service.SocieteService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/SocieteAct")
public class SocieteController {

    @Autowired
    private SocieteService societeService;
    @Autowired
    private DemandeSocieteRepository demandeSocieteRepository;
    @Autowired
    private SocieteRepository societeRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/ajout_societe")
    public ResponseEntity<?> ajoute_societe(@RequestBody SocieteDTO societe) throws MessagingException {
        String resp = societeService.ajouter_societer(societe);
        if (resp.equals("nom societe existe")) {
            return ResponseEntity.notFound().build();
        } else if (resp.equals("utilisateur")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Utilisateur not found");
        
        } else if (resp.equals("email")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
        } else {
            return ResponseEntity.ok("");
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/accepter/{id}")
    public ResponseEntity<?> accepter(@PathVariable Long id) throws MessagingException {
        String res=societeService.societe(id);
        if(res.equals("ok")){
            return ResponseEntity.ok("");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/refuser/{id}")
    public ResponseEntity<?> refuser(@PathVariable Long id) throws MessagingException {
        String res=societeService.societee(id);
        if(res.equals("ok")){
            return ResponseEntity.ok("");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all_demande")
    public List<DemandeSociete> all_demande() {
        return demandeSocieteRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDTO loginDTO) {
        String res =societeService.login(loginDTO);
        if(res.equals("ok")){
            societe societe = societeRepository.findByNom(loginDTO.getEmail());
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setEmail(societe.getNom());
            loginResponseDTO.setProfilepic(societe.getProfilePic());
            loginResponseDTO.setRole("societe");
            loginResponseDTO.setId(societe.getId());
            return ResponseEntity.ok(loginResponseDTO);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/suiviedemande/{id}")
    public ResponseEntity<?> suivie_Demande(@PathVariable Long id){
        DemandeSociete demandeSociete = demandeSocieteRepository.getById(id);
        if(demandeSociete != null){
            String response = demandeSociete.getStatus();
            return ResponseEntity.ok(Map.of("msg", response));
        } else {
            return ResponseEntity.badRequest().body(Map.of("msg", "error"));
        }
    }

}
