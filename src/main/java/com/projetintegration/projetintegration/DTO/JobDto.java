package com.projetintegration.projetintegration.DTO;

import java.time.LocalDate;
import java.util.Date;

public class JobDto {
    private Long idjob;
    private Long salaire;
    private String nom;
    private String localisation;
    private String societeName;
    private String societeImage;
    private String type;
    private LocalDate date;

    private String description;
    public Long getIdjob() {
        return idjob;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdjob(Long idjob) {
        this.idjob = idjob;
    }

    public Long getSalaire() {
        return salaire;
    }

    public void setSalaire(Long salaire) {
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getSocieteName() {
        return societeName;
    }

    public void setSocieteName(String societeName) {
        this.societeName = societeName;
    }

    public String getSocieteImage() {
        return societeImage;
    }

    public void setSocieteImage(String societeImage) {
        this.societeImage = societeImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
