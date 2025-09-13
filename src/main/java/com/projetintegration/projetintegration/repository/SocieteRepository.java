package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteRepository extends JpaRepository<societe, Long> {
    societe getById(Long id);

    societe findByNom(String nom);

    societe findByNomAndMdp(String email, String mdp);

}
