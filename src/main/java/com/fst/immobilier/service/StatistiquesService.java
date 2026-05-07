package com.fst.immobilier.service;

import com.fst.immobilier.repository.BienRepository;
import com.fst.immobilier.repository.VisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatistiquesService {

    @Autowired
    private BienRepository bienRepository;

    @Autowired
    private VisiteRepository visiteRepository;

    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        
        List<Map<String, Object>> countByStatut = bienRepository.countBiensByStatut();
        stats.put("biensParStatut", countByStatut);
        
        Double ca = bienRepository.calculateChiffreAffairesSimule();
        stats.put("chiffreAffairesSimule", ca != null ? ca : 0.0);
        
        Long visitesMois = visiteRepository.countVisitesThisMonth();
        stats.put("visitesMois", visitesMois != null ? visitesMois : 0L);
        
        return stats;
    }
}
