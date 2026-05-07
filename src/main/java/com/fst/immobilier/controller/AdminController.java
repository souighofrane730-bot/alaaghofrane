package com.fst.immobilier.controller;

import com.fst.immobilier.dto.AgentDTO;
import com.fst.immobilier.service.AgentService;
import com.fst.immobilier.service.StatistiquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StatistiquesService statistiquesService;

    @Autowired
    private AgentService agentService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("stats", statistiquesService.getDashboardStats());
        return "admin/dashboard";
    }

    @GetMapping("/agents")
    public String listAgents(Model model) {
        model.addAttribute("agents", agentService.findAll());
        return "admin/agents/list";
    }

    @PostMapping("/agents/toggle/{id}")
    public String toggleAgent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        agentService.toggleActif(id);
        redirectAttributes.addFlashAttribute("message", "Statut de l'agent modifié.");
        return "redirect:/admin/agents";
    }
}

