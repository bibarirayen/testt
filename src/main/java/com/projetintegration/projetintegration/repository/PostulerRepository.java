package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.postuler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostulerRepository extends JpaRepository<postuler, Long> {
    public postuler getByUtilisateurAndAnnonce(Utilisateur utilisateur, Annonce annonce);

    List<postuler> findAllByUtilisateur_Id(Long utilisateurId);
    boolean existsByUtilisateur_IdAndAnnonce_Idannonce(Long userId, Long idannonce);
    List<postuler> findAllByAnnonce(Optional<Annonce> annonce);
    Optional<postuler> findByIdpostuler(Long idpostuler);


}
