package com.example.examen.web.controllers.impl;

import com.example.examen.data.entites.Client;
import com.example.examen.services.impl.ClientService;
import com.example.examen.web.controllers.IClientController;
import com.example.examen.web.dtos.request.ClientRequestDTO;
import com.example.examen.web.dtos.response.ClientResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController implements IClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public ResponseEntity<ClientResponseDTO> ajouterClient(@RequestBody @Valid ClientRequestDTO dto) {
        Client client = clientService.create(dto);
        ClientResponseDTO response = new ClientResponseDTO(client.getId(), client.getNom(), client.getTelephone(), client.getAdresse());
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> list = clientService.getAll().stream().map(
                c -> new ClientResponseDTO(c.getId(), c.getNom(), c.getTelephone(), c.getAdresse())
        ).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        Client client = clientService.getById(id);
        if (client == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new ClientResponseDTO(client.getId(), client.getNom(), client.getTelephone(), client.getAdresse()));
    }
}
