package com.projetintegration.projetintegration.DTO;

public class SocieteDTO {
    private String nom;
    private String description;
    private String email;
    private String localisation;
    private String idhr;
    private String profilePic;
    private String mdp;

    public SocieteDTO(String nom, String description, String email, String localisation, String idhr, String profilePic,String mdp) {
        this.nom = nom;
        this.description = description;
        this.email = email;
        this.localisation = localisation;
        this.idhr = idhr;
        this.profilePic = profilePic;
        this.mdp=mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getIdhr() {
        return idhr;
    }

    public void setIdhr(String idhr) {
        this.idhr = idhr;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
