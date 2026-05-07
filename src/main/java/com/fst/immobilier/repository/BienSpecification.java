package com.fst.immobilier.repository;

import com.fst.immobilier.entity.Bien;
import com.fst.immobilier.entity.enums.StatutBien;
import com.fst.immobilier.entity.enums.TypeBien;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BienSpecification {

    public static Specification<Bien> withFilters(
            TypeBien type, String ville, BigDecimal prixMin, BigDecimal prixMax,
            Double surfaceMin, Double surfaceMax, Integer nbPieces, StatutBien statut) {
            
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (type != null) {
                predicates.add(cb.equal(root.get("type"), type));
            }
            if (ville != null && !ville.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("ville")), "%" + ville.toLowerCase() + "%"));
            }
            if (prixMin != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("prix"), prixMin));
            }
            if (prixMax != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("prix"), prixMax));
            }
            if (surfaceMin != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("surface"), surfaceMin));
            }
            if (surfaceMax != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("surface"), surfaceMax));
            }
            if (nbPieces != null && nbPieces > 0) {
                predicates.add(cb.equal(root.get("nbPieces"), nbPieces));
            }
            if (statut != null) {
                predicates.add(cb.equal(root.get("statut"), statut));
            } else {
                // By default, mostly show PUBLIE
                predicates.add(cb.equal(root.get("statut"), StatutBien.PUBLIE));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
