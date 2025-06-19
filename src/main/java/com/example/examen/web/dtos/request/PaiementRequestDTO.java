package com.example.examen.web.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PaiementRequestDTO {
    @NotBlank(message = "La date est obligatoire")
    private String date;

    @NotNull(message = "Le montant est obligatoire")
    @Positive(message = "Le montant doit être positif")
    private Double montant;

    // Getters et Setters
}
