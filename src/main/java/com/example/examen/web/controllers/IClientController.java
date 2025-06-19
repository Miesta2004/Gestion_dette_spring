package com.example.examen.web.controllers;

import com.example.examen.web.dtos.request.ClientRequestDTO;
import com.example.examen.web.dtos.response.ClientResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IClientController {

    @PostMapping
    ResponseEntity<ClientResponseDTO> ajouterClient(@RequestBody ClientRequestDTO dto);

    @GetMapping
    ResponseEntity<List<ClientResponseDTO>> getAllClients();

    @GetMapping("/{id}")
    ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id);
}
