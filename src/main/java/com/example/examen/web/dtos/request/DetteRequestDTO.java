package com.example.examen.web.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DetteRequestDTO {
    @NotBlank(message = "La date est obligatoire")
    private String date;

    @NotNull(message = "Le montant de la dette est obligatoire")
    @Positive(message = "Le montant de la dette doit être positif")
    private Double montantDette;

    // Getters et Setters
}
