package com.fst.immobilier.dto;

import com.fst.immobilier.entity.enums.StatutBien;
import com.fst.immobilier.entity.enums.TypeBien;
import java.math.BigDecimal;

public class BienSearchDTO {
    private TypeBien type;
    private String ville;
    private BigDecimal prixMin;
    private BigDecimal prixMax;
    private Double surfaceMin;
    private Double surfaceMax;
    private Integer nbPieces;
    private StatutBien statut;

    // Getters and Setters
    public TypeBien getType() { return type; }
    public void setType(TypeBien type) { this.type = type; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public BigDecimal getPrixMin() { return prixMin; }
    public void setPrixMin(BigDecimal prixMin) { this.prixMin = prixMin; }
    public BigDecimal getPrixMax() { return prixMax; }
    public void setPrixMax(BigDecimal prixMax) { this.prixMax = prixMax; }
    public Double getSurfaceMin() { return surfaceMin; }
    public void setSurfaceMin(Double surfaceMin) { this.surfaceMin = surfaceMin; }
    public Double getSurfaceMax() { return surfaceMax; }
    public void setSurfaceMax(Double surfaceMax) { this.surfaceMax = surfaceMax; }
    public Integer getNbPieces() { return nbPieces; }
    public void setNbPieces(Integer nbPieces) { this.nbPieces = nbPieces; }
    public StatutBien getStatut() { return statut; }
    public void setStatut(StatutBien statut) { this.statut = statut; }
}
