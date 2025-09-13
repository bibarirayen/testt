package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);
    Utilisateur findByTel(String tel);
    Utilisateur getById(Long id);

}
