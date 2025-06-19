package com.example.examen.web.controllers.impl;

import com.example.examen.data.entites.Dette;
import com.example.examen.services.impl.DetteService;
import com.example.examen.web.controllers.IDetteController;
import com.example.examen.web.dtos.request.DetteRequestDTO;
import com.example.examen.web.dtos.response.DetteResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dettes")
public class DetteController implements IDetteController {

    private final DetteService detteService;

    public DetteController(DetteService detteService) {
        this.detteService = detteService;
    }

    @PostMapping
    public ResponseEntity<DetteResponseDTO> ajouterDette(@RequestBody @Valid DetteRequestDTO dto) {
        Dette dette = detteService.create(dto);
        DetteResponseDTO response = new DetteResponseDTO(
                dette.getId(),
                dette.getDate(),
                dette.getMontantDette(),
                dette.getMontantPaye(),
                dette.getMontantRestant()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DetteResponseDTO>> getAllDettes() {
        List<DetteResponseDTO> list = detteService.getAll().stream().map(
                dette -> new DetteResponseDTO(
                        dette.getId(),
                        dette.getDate(),
                        dette.getMontantDette(),
                        dette.getMontantPaye(),
                        dette.getMontantRestant()
                )
        ).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/client/{telephone}")
    public ResponseEntity<List<DetteResponseDTO>> getDettesParTelephone(@PathVariable String telephone) {
        List<DetteResponseDTO> list = detteService.findByClientTelephone(telephone).stream().map(
                dette -> new DetteResponseDTO(
                        dette.getId(),
                        dette.getDate(),
                        dette.getMontantDette(),
                        dette.getMontantPaye(),
                        dette.getMontantRestant()
                )
        ).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
