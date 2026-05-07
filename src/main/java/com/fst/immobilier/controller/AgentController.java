package com.fst.immobilier.controller;

import com.fst.immobilier.entity.Bien;
import com.fst.immobilier.entity.enums.StatutBien;
import com.fst.immobilier.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private BienService bienService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Bien> biens = bienService.findAll();
        model.addAttribute("biens", biens);
        return "agent/dashboard";
    }

    @PostMapping("/bien/{id}/statut")
    public String changerStatut(@PathVariable Long id, @RequestParam StatutBien statut, RedirectAttributes redirectAttributes) {
        try {
            bienService.changerStatut(id, statut);
            redirectAttributes.addFlashAttribute("message", "Statut mis à jour avec succès!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/agent/dashboard";
    }

    @PostMapping("/bien/{id}/upload")
    public String uploadPhotos(@PathVariable Long id, @RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) {
        try {
            bienService.uploadPhotos(id, files);
            redirectAttributes.addFlashAttribute("message", "Photos ajoutées avec succès!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/agent/dashboard";
    }

    @GetMapping("/biens/modifier/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Bien bien = bienService.findById(id).orElseThrow(() -> new RuntimeException("Bien non trouvé"));
        model.addAttribute("bien", bien);
        return "agent/modifier";
    }

    @PostMapping("/biens/modifier/{id}")
    public String updateBien(@PathVariable Long id, @ModelAttribute Bien bien, RedirectAttributes redirectAttributes) {
        try {
            Bien existing = bienService.findById(id).orElseThrow(() -> new RuntimeException("Bien non trouvé"));
            // Update fields
            existing.setTitre(bien.getTitre());
            existing.setDescription(bien.getDescription());
            existing.setPrix(bien.getPrix());
            existing.setSurface(bien.getSurface());
            existing.setNbPieces(bien.getNbPieces());
            existing.setVille(bien.getVille());
            existing.setType(bien.getType());
            
            bienService.saveBien(existing);
            redirectAttributes.addFlashAttribute("message", "Bien modifié avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la modification : " + e.getMessage());
        }
        return "redirect:/catalogue";
    }

    @PostMapping("/biens/supprimer/{id}")
    public String deleteBien(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bienService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Bien supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }
        return "redirect:/catalogue";
    }
}
