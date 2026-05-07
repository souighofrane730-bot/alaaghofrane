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
}
