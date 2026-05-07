package com.fst.immobilier.dto;

import com.fst.immobilier.entity.enums.StatutBien;
import com.fst.immobilier.entity.enums.TypeBien;
import com.fst.immobilier.entity.enums.TypeTransaction;
import java.math.BigDecimal;

public class BienDTO {
    private Long id;
    private String reference;
    private String titre;
    private String description;
    private TypeBien type;
    private TypeTransaction typeTransaction;
    private double surface;
    private int nbPieces;
    private BigDecimal prix;
    private String ville;
    private String quartier;
    private String adresse;
    private String codePostal;
    private StatutBien statut;
    private Long agentId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public TypeBien getType() { return type; }
    public void setType(TypeBien type) { this.type = type; }
    public TypeTransaction getTypeTransaction() { return typeTransaction; }
    public void setTypeTransaction(TypeTransaction typeTransaction) { this.typeTransaction = typeTransaction; }
    public double getSurface() { return surface; }
    public void setSurface(double surface) { this.surface = surface; }
    public int getNbPieces() { return nbPieces; }
    public void setNbPieces(int nbPieces) { this.nbPieces = nbPieces; }
    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public String getQuartier() { return quartier; }
    public void setQuartier(String quartier) { this.quartier = quartier; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }
    public StatutBien getStatut() { return statut; }
    public void setStatut(StatutBien statut) { this.statut = statut; }
    public Long getAgentId() { return agentId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }
}
