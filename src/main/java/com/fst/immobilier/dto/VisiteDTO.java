package com.fst.immobilier.dto;

import java.time.LocalDateTime;

public class VisiteDTO {
    private Long bienId;
    private String clientNom;
    private String clientEmail;
    private String clientTelephone;
    private String dateVisite; // Format string to handle HTML datetime-local
    private String message;

    // Getters and Setters
    public Long getBienId() { return bienId; }
    public void setBienId(Long bienId) { this.bienId = bienId; }
    public String getClientNom() { return clientNom; }
    public void setClientNom(String clientNom) { this.clientNom = clientNom; }
    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
    public String getClientTelephone() { return clientTelephone; }
    public void setClientTelephone(String clientTelephone) { this.clientTelephone = clientTelephone; }
    public String getDateVisite() { return dateVisite; }
    public void setDateVisite(String dateVisite) { this.dateVisite = dateVisite; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
