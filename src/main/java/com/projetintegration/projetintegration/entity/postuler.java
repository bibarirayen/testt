package com.projetintegration.projetintegration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "postuler")
public class postuler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postuler", nullable = false)
    private Long idpostuler;

    @ManyToOne
    @JoinColumn (name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn (name = "id_annonce", nullable = false)
    private Annonce annonce;

    @Column (name = "cvurl", nullable = false)
    private String cvurl;

    @Column (name = "lettreurl", nullable = false)
    private String lettreurl;

    @Column (name = "status", nullable = false)
    private String status;

    public postuler() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public postuler(Utilisateur utilisateur, Annonce annonce) {
        this.utilisateur = utilisateur;
        this.annonce = annonce;
    }

    public String getCvurl() {
        return cvurl;
    }

    public void setCvurl(String cvurl) {
        this.cvurl = cvurl;
    }

    public String getLettreurl() {
        return lettreurl;
    }

    public void setLettreurl(String lettreurl) {
        this.lettreurl = lettreurl;
    }

    public Long getId_postuler() {
        return idpostuler;
    }

    public void setId_postuler(Long id_postuler) {
        this.idpostuler = id_postuler;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public com.projetintegration.projetintegration.entity.Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(com.projetintegration.projetintegration.entity.Annonce annonce) {
        this.annonce = annonce;
    }
}
