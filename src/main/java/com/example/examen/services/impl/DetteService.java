package com.example.examen.services.impl;

import com.example.examen.data.entites.Client;
import com.example.examen.data.entites.Dette;
import com.example.examen.data.repositories.ClientRepository;
import com.example.examen.data.repositories.DetteRepository;
import com.example.examen.services.IDetteService;
import com.example.examen.web.dtos.request.DetteRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DetteService implements IDetteService {

    private final DetteRepository detteRepository;
    private final ClientRepository clientRepository;

    public DetteService(DetteRepository detteRepository, ClientRepository clientRepository) {
        this.detteRepository = detteRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Dette create(DetteRequestDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Dette dette = new Dette();
        dette.setDate(dto.getDate());
        dette.setMontantDette(dto.getMontantDette());
        dette.setClient(client);
        dette.setMontantPaye(0.0); // initial
        dette.setMontantRestant(dto.getMontantDette());

        return detteRepository.save(dette);
    }

    @Override
    public Dette create(Dette objet) {
        return detteRepository.save(objet);
    }

    @Override
    public Dette getById(Long id) {
        return detteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dette> getAll() {
        return detteRepository.findAll();
    }

}
