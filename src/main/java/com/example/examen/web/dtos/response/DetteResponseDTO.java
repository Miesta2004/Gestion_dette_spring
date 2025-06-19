package com.example.examen.web.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetteResponseDTO {
    private Long id;
    private String date;
    private Double montantDette;
    private Double montantPaye;
    private Double montantRestant;

    // Getters, Setters, Constructeur
}
