package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.DTO.AnnonceDTO;
import com.projetintegration.projetintegration.DTO.PostuleDTO;
import com.projetintegration.projetintegration.DTO.PostulerDTO;
import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.postuler;
import com.projetintegration.projetintegration.repository.AnnonceRepository;
import com.projetintegration.projetintegration.repository.PostulerRepository;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostulerService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private PostulerRepository postulerRepository;
    public String PostulerDemande(PostulerDTO postuler){
        Utilisateur utilisateur = utilisateurRepository.getById(postuler.getId_utilisateur());
        Annonce annonce = annonceRepository.getByIdannonce(postuler.getId_annonce());
        postuler postuler1=postulerRepository.getByUtilisateurAndAnnonce(utilisateur,annonce);
        if(utilisateur!=null && annonce!=null){
            if(postuler1==null){
                postuler postuler2 = new postuler(utilisateur,annonce);
                postuler2.setCvurl(postuler.getCvurl());
                postuler2.setLettreurl(postuler.getLettreurl());
                postuler2.setStatus("demande envoyé");
                postulerRepository.save(postuler2);
                return "oui";
            }
            else{
                return "non";
            }
        }
        else{
            return "non";
        }

    }
    public List<PostuleDTO> getAll(Long id) {
        List<postuler> postuler = postulerRepository.findAllByUtilisateur_Id(id);
        List<PostuleDTO> postuleDTOS = new ArrayList<>();
        for (postuler post : postuler) {
            postuleDTOS.add(new PostuleDTO(
                    post.getId_postuler(),
                    post.getAnnonce().getSociete().getNom(),
                    post.getStatus(),
                    post.getAnnonce().getSociete().getProfilePic(),
                    post.getAnnonce().getNomannonce()
            ));
        }
        return postuleDTOS;
    }
}
