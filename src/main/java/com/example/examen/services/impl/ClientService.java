package com.example.examen.services.impl;

import com.example.examen.data.entites.Client;
import com.example.examen.data.repositories.ClientRepository;
import com.example.examen.services.IClientService;
import com.example.examen.web.dtos.request.ClientRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(ClientRequestDTO dto) {
        Client client = new Client();
        client.setNom(dto.getNom());
        client.setTelephone(dto.getTelephone());
        client.setAdresse(dto.getAdresse());
        return clientRepository.save(client);
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findByTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone);
    }
}
