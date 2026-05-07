package com.fst.immobilier.controller;

import com.fst.immobilier.dto.VisiteDTO;
import com.fst.immobilier.service.VisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/visite")
public class VisiteController {

    @Autowired
    private VisiteService visiteService;

    @PostMapping("/reserver")
    public String reserver(VisiteDTO dto, RedirectAttributes redirectAttributes) {
        try {
            visiteService.planifierVisite(dto);
            redirectAttributes.addFlashAttribute("message", "Votre demande de visite a été enregistrée. Un agent vous contactera bientôt.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la réservation : " + e.getMessage());
        }
        return "redirect:/catalogue/" + dto.getBienId();
    }
}
