package com.fst.immobilier.service;

import com.fst.immobilier.entity.Agent;
import com.fst.immobilier.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    public Agent findById(Long id) {
        return agentRepository.findById(id).orElseThrow(() -> new RuntimeException("Agent non trouvé"));
    }

    @Transactional
    public void toggleActif(Long id) {
        Agent agent = findById(id);
        agent.setActif(!agent.isActif());
        agentRepository.save(agent);
    }

    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }
}
