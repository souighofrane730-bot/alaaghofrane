package com.fst.immobilier.repository;

import com.fst.immobilier.entity.PhotoBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoBienRepository extends JpaRepository<PhotoBien, Long> {
}
