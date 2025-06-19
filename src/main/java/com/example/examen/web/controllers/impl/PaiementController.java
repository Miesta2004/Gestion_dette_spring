package com.example.examen.web.controllers.impl;

import com.example.examen.data.entites.Paiement;
import com.example.examen.services.impl.PaiementService;
import com.example.examen.web.controllers.IPaiementController;
import com.example.examen.web.dtos.request.PaiementRequestDTO;
import com.example.examen.web.dtos.response.PaiementResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController implements IPaiementController {

    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping
    public ResponseEntity<PaiementResponseDTO> ajouterPaiement(@RequestBody @Valid PaiementRequestDTO dto) {
        Paiement paiement = paiementService.create(dto);
        PaiementResponseDTO response = new PaiementResponseDTO(
                paiement.getId(),
                paiement.getMontantDette(),
                paiement.getDate(),
                paiement.getDette().getId()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PaiementResponseDTO>> getAllPaiements() {
        List<PaiementResponseDTO> list = paiementService.getAll().stream().map(
                p -> new PaiementResponseDTO(p.getId(), p.getMontantDette(), p.getDate(), p.getDette().getId())
        ).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/client/{telephone}")
    public ResponseEntity<List<PaiementResponseDTO>> getPaiementsParTelephone(@PathVariable String telephone) {
        List<PaiementResponseDTO> list = paiementService.findByClientTelephone(telephone).stream().map(
                p -> new PaiementResponseDTO(p.getId(), p.getMontant(), p.getDate(), p.getDette().getId())
        ).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/dette/{detteId}")
    public ResponseEntity<List<PaiementResponseDTO>> getPaiementsParDette(@PathVariable Long detteId) {
        List<PaiementResponseDTO> list = paiementService.findByDetteNumero(detteId).stream().map(
                p -> new PaiementResponseDTO(p.getId(), p.getMontant(), p.getDate(), p.getDette().getId())
        ).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
