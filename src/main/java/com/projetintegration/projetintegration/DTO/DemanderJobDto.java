package com.projetintegration.projetintegration.DTO;

public class DemanderJobDto {
    private Long id_postuler;
    private String nom;
    private String prenom;
    private String cv;
    private String lettre;
    private String statut;
    public DemanderJobDto() {};
    public DemanderJobDto(Long id_postuler, String nom, String prenom, String cv, String lettre, String statut) {
        this.id_postuler = id_postuler;
        this.nom = nom;
        this.prenom = prenom;
        this.cv = cv;
        this.lettre = lettre;
        this.statut = statut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettre() {
        return lettre;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Long getId_postuler() {
        return id_postuler;
    }

    public void setId_postuler(Long id_postuler) {
        this.id_postuler = id_postuler;
    }
}
