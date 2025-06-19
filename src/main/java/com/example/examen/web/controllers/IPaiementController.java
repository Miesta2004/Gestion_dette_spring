package com.example.examen.web.controllers;

import com.example.examen.web.dtos.request.PaiementRequestDTO;
import com.example.examen.web.dtos.response.PaiementResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPaiementController {

    @PostMapping
    ResponseEntity<PaiementResponseDTO> ajouterPaiement(@RequestBody PaiementRequestDTO dto);

    @GetMapping
    ResponseEntity<List<PaiementResponseDTO>> getAllPaiements();

    @GetMapping("/dette/{detteId}")
    ResponseEntity<List<PaiementResponseDTO>> getPaiementsParDette(@PathVariable Long detteId);
}
