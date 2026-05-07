package com.fst.immobilier.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "photos_bien")
public class PhotoBien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bien_id", nullable = false)
    private Bien bien;

    private String url;
    private int ordre;
    private boolean principale;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Bien getBien() { return bien; }
    public void setBien(Bien bien) { this.bien = bien; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public int getOrdre() { return ordre; }
    public void setOrdre(int ordre) { this.ordre = ordre; }
    public boolean isPrincipale() { return principale; }
    public void setPrincipale(boolean principale) { this.principale = principale; }
}
