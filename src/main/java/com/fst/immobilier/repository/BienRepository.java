package com.fst.immobilier.repository;

import com.fst.immobilier.entity.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long>, JpaSpecificationExecutor<Bien> {

    @Query("SELECT b.statut as statut, COUNT(b) as count FROM Bien b GROUP BY b.statut")
    List<Map<String, Object>> countBiensByStatut();

    @Query("SELECT SUM(b.prix) FROM Bien b WHERE b.statut = 'VENDU' OR b.statut = 'LOUE'")
    Double calculateChiffreAffairesSimule();
}
