package com.fst.immobilier.service;

import com.fst.immobilier.entity.Bien;
import com.fst.immobilier.entity.PhotoBien;
import com.fst.immobilier.entity.enums.StatutBien;
import com.fst.immobilier.repository.BienRepository;
import com.fst.immobilier.repository.PhotoBienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    @Autowired
    private PhotoBienRepository photoBienRepository;

    private final Path rootLocation = Paths.get("uploads");

    public BienService() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public Page<Bien> rechercherBiens(Specification<Bien> spec, Pageable pageable) {
        return bienRepository.findAll(spec, pageable);
    }
    
    public List<Bien> findAll() {
        return bienRepository.findAll();
    }

    public Optional<Bien> findById(Long id) {
        return bienRepository.findById(id);
    }

    @Transactional
    public Bien saveBien(Bien bien) {
        return bienRepository.save(bien);
    }

    @Transactional
    public Bien changerStatut(Long id, StatutBien nouveauStatut) {
        Bien bien = bienRepository.findById(id).orElseThrow(() -> new RuntimeException("Bien non trouvé"));
        
        // Logique métier : BROUILLON ne peut passer qu'à PUBLIE
        if (bien.getStatut() == StatutBien.BROUILLON && nouveauStatut != StatutBien.PUBLIE && nouveauStatut != StatutBien.BROUILLON) {
            throw new RuntimeException("Un brouillon ne peut être que publié.");
        }
        
        bien.setStatut(nouveauStatut);
        return bienRepository.save(bien);
    }

    @Transactional
    public void uploadPhotos(Long id, MultipartFile[] files) {
        Bien bien = bienRepository.findById(id).orElseThrow(() -> new RuntimeException("Bien non trouvé"));
        
        if (bien.getPhotos().size() + files.length > 10) {
            throw new RuntimeException("Un bien ne peut avoir que 10 photos maximum.");
        }

        for (MultipartFile file : files) {
            if (file.isEmpty()) continue;
            
            String contentType = file.getContentType();
            if (contentType == null || (!contentType.equals("image/jpeg") && !contentType.equals("image/png") && !contentType.equals("image/webp"))) {
                throw new RuntimeException("Type de fichier non valide. Seuls JPG, PNG et WEBP sont autorisés.");
            }

            try {
                String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Files.copy(file.getInputStream(), this.rootLocation.resolve(filename));

                PhotoBien photo = new PhotoBien();
                photo.setBien(bien);
                photo.setUrl(filename);
                photo.setPrincipale(bien.getPhotos().isEmpty()); // La première est principale
                
                bien.getPhotos().add(photo);
                photoBienRepository.save(photo);
                
            } catch (Exception e) {
                throw new RuntimeException("FAIL to store file Error: " + e.getMessage());
            }
        }
    }
}
