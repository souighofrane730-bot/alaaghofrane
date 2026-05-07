package com.fst.immobilier.entity;

import com.fst.immobilier.entity.enums.ImpressionVisite;
import com.fst.immobilier.entity.enums.StatutVisite;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visites")
public class Visite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bien_id", nullable = false)
    private Bien bien;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;

    private LocalDateTime dateHeure;

    @Enumerated(EnumType.STRING)
    private StatutVisite statut = StatutVisite.PLANIFIEE;

    @Column(columnDefinition = "TEXT")
    private String compteRendu;

    @Enumerated(EnumType.STRING)
    private ImpressionVisite impression;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Bien getBien() { return bien; }
    public void setBien(Bien bien) { this.bien = bien; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public Agent getAgent() { return agent; }
    public void setAgent(Agent agent) { this.agent = agent; }
    public LocalDateTime getDateHeure() { return dateHeure; }
    public void setDateHeure(LocalDateTime dateHeure) { this.dateHeure = dateHeure; }
    public StatutVisite getStatut() { return statut; }
    public void setStatut(StatutVisite statut) { this.statut = statut; }
    public String getCompteRendu() { return compteRendu; }
    public void setCompteRendu(String compteRendu) { this.compteRendu = compteRendu; }
    public ImpressionVisite getImpression() { return impression; }
    public void setImpression(ImpressionVisite impression) { this.impression = impression; }
}
