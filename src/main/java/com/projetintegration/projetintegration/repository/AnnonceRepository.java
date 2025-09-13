package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    Annonce getByIdannonce(Long id);
    List<Annonce> findAll();

    List<Annonce> findByNomannonceContaining(String nomannonce);

    List<Annonce> findAllBySociete_Id(Long id);

    List<Annonce> findAllBySociete(societe societe);

}
