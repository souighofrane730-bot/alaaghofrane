package com.fst.immobilier.controller;

import com.fst.immobilier.dto.BienSearchDTO;
import com.fst.immobilier.entity.Bien;
import com.fst.immobilier.repository.BienSpecification;
import com.fst.immobilier.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CatalogueController {

    @Autowired
    private BienService bienService;

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/catalogue";
    }

    @GetMapping("/catalogue")
    public String catalogue(
            @ModelAttribute BienSearchDTO searchDTO,
            @RequestParam(defaultValue = "0") int page,
            Model model) {
        
        Specification<Bien> spec = BienSpecification.withFilters(
            searchDTO.getType(), searchDTO.getVille(), searchDTO.getPrixMin(), 
            searchDTO.getPrixMax(), searchDTO.getSurfaceMin(), searchDTO.getSurfaceMax(), 
            searchDTO.getNbPieces(), searchDTO.getStatut()
        );

        Page<Bien> biens = bienService.rechercherBiens(spec, PageRequest.of(page, 9));
        
        model.addAttribute("biens", biens);
        model.addAttribute("searchDTO", searchDTO);
        
        return "catalogue/index";
    }

    @GetMapping("/catalogue/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Bien bien = bienService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bien Id:" + id));
        model.addAttribute("bien", bien);
        return "catalogue/detail";
    }

    @PostMapping("/catalogue/{id}/contact")
    public String contactAgence(@PathVariable Long id, @RequestParam String nom, @RequestParam String email, @RequestParam String message, org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        // Logique fictive pour l'envoi d'email
        redirectAttributes.addFlashAttribute("message", "Merci " + nom + ", votre message a bien été envoyé à l'agence.");
        return "redirect:/catalogue/" + id;
    }

    @PostMapping("/catalogue/{id}/visite")
    public String planifierVisite(@PathVariable Long id, @RequestParam String nom, @RequestParam String email, @RequestParam String date, org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        // Logique fictive pour la sauvegarde de la visite
        redirectAttributes.addFlashAttribute("message", "Votre demande de visite pour le " + date.replace("T", " à ") + " a été transmise à l'agent.");
        return "redirect:/catalogue/" + id;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
