package com.projetintegration.projetintegration.DTO;

import java.util.Date;

public class PostuleDTO {
    private Long id;
    private String nomsociete;
    private String nomjob;
    private String societeimg;
    private String statut;

    public PostuleDTO(Long id,String nomsociete, String statut, String societeimg, String nomjob) {
        this.id = id;
        this.nomsociete = nomsociete;
        this.statut = statut;
        this.societeimg = societeimg;
        this.nomjob = nomjob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomsociete() {
        return nomsociete;
    }

    public void setNomsociete(String nomsociete) {
        this.nomsociete = nomsociete;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getSocieteimg() {
        return societeimg;
    }

    public void setSocieteimg(String societeimg) {
        this.societeimg = societeimg;
    }



    public String getNomjob() {
        return nomjob;
    }

    public void setNomjob(String nomjob) {
        this.nomjob = nomjob;
    }
}
