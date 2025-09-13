package com.projetintegration.projetintegration.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annonce", nullable = false)
    private Long idannonce;

    @ManyToOne
    @JoinColumn(name = "id_societe", nullable = false)
    private societe societe;

    @Column (name="nomannonce", nullable=false)
    private String nomannonce;

    @Column (name="localisation", nullable=false)
    private String localisation;
    @Column (name="description", nullable=false)
    private String description;
    @Column (name="type", nullable=false)
    private String type;
    @Column (name="salaire", nullable=false)
    private Long salaire;
    @Column(name = "date_poste", nullable = false, updatable = false)
    private LocalDate date_poste;

    public Annonce() {
    }

    public Annonce(societe byId, String description, String localisation, String nom, Long prix, String type) {
        this.societe = byId;
        this.description = description;
        this.date_poste=LocalDate.now();
        this.localisation=localisation;
        this.nomannonce=nom;
        this.salaire=prix;
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSalaire() {
        return salaire;
    }

    public void setSalaire(Long salaire) {
        this.salaire = salaire;
    }

    public Annonce(com.projetintegration.projetintegration.entity.societe societe, String description, String localisation, String nom) {
        this.societe = societe;
        this.description = description;
        this.date_poste=LocalDate.now();
        this.localisation=localisation;
        this.nomannonce=nom;
    }

    public Long getId_annonce() {
        return idannonce;
    }

    public void setId_annonce(Long id_annonce) {
        this.idannonce = id_annonce;
    }

    public com.projetintegration.projetintegration.entity.societe getSociete() {
        return societe;
    }

    public void setSociete(com.projetintegration.projetintegration.entity.societe societe) {
        this.societe = societe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate_poste() {
        return date_poste;
    }

    public void setDate_poste(LocalDate date_poste) {
        this.date_poste = date_poste;
    }

    public String getNomannonce() {
        return nomannonce;
    }

    public void setNomannonce(String nomannonce) {
        this.nomannonce = nomannonce;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
