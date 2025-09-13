package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.DemandeSociete;
import com.projetintegration.projetintegration.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeSocieteRepository extends JpaRepository<DemandeSociete, Long> {
    DemandeSociete getById(Long id);
    List<DemandeSociete> findAll();
}
