package com.fst.immobilier.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    
    @Column(unique = true)
    private String email;
    private String telephone;
    private String numeroLicence;
    private boolean actif = true;

    @OneToMany(mappedBy = "agent")
    private List<Bien> biens;

    @OneToMany(mappedBy = "agent")
    private List<Visite> visites;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getNumeroLicence() { return numeroLicence; }
    public void setNumeroLicence(String numeroLicence) { this.numeroLicence = numeroLicence; }
    public boolean isActif() { return actif; }
    public void setActif(boolean actif) { this.actif = actif; }
    public List<Bien> getBiens() { return biens; }
    public void setBiens(List<Bien> biens) { this.biens = biens; }
    public List<Visite> getVisites() { return visites; }
    public void setVisites(List<Visite> visites) { this.visites = visites; }
}
