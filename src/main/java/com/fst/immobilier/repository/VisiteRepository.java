package com.fst.immobilier.repository;

import com.fst.immobilier.entity.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteRepository extends JpaRepository<Visite, Long> {
    
    @Query("SELECT COUNT(v) FROM Visite v WHERE MONTH(v.dateHeure) = MONTH(CURRENT_DATE) AND YEAR(v.dateHeure) = YEAR(CURRENT_DATE)")
    Long countVisitesThisMonth();
}
