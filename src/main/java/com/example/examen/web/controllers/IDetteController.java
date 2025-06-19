package com.example.examen.web.controllers;

import com.example.examen.web.dtos.request.DetteRequestDTO;
import com.example.examen.web.dtos.response.DetteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IDetteController {

    @PostMapping
    ResponseEntity<DetteResponseDTO> ajouterDette(@RequestBody DetteRequestDTO dto);

    @GetMapping
    ResponseEntity<List<DetteResponseDTO>> getAllDettes();

    @GetMapping("/client/{telephone}")
    ResponseEntity<List<DetteResponseDTO>> getDettesParTelephone(@PathVariable String telephone);
}
