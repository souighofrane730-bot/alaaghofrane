package com.fst.immobilier.service;

import com.fst.immobilier.dto.VisiteDTO;
import com.fst.immobilier.entity.Bien;
import com.fst.immobilier.entity.Client;
import com.fst.immobilier.entity.Visite;
import com.fst.immobilier.entity.enums.StatutVisite;
import com.fst.immobilier.repository.BienRepository;
import com.fst.immobilier.repository.ClientRepository;
import com.fst.immobilier.repository.VisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisiteService {

    @Autowired
    private VisiteRepository visiteRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BienRepository bienRepository;

    public List<Visite> findAll() {
        return visiteRepository.findAll();
    }

    @Transactional
    public void planifierVisite(VisiteDTO dto) {
        Bien bien = bienRepository.findById(dto.getBienId())
                .orElseThrow(() -> new RuntimeException("Bien non trouvé"));

        // Simplifié : on crée ou récupère le client par email
        Client client = new Client();
        client.setNom(dto.getClientNom());
        client.setEmail(dto.getClientEmail());
        client.setTelephone(dto.getClientTelephone());
        client = clientRepository.save(client);

        Visite visite = new Visite();
        visite.setBien(bien);
        visite.setClient(client);
        visite.setAgent(bien.getAgent());
        visite.setDateHeure(LocalDateTime.parse(dto.getDateVisite()));
        visite.setStatut(StatutVisite.PLANIFIEE);

        visiteRepository.save(visite);
    }
}

