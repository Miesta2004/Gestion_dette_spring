package com.example.examen.web.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClientRequestDTO {
    @NotBlank
    private String nom;

    @NotBlank
    @Pattern(regexp = "^(77|76|75)[0-9]{7}$", message = "Numéro de téléphone invalide")
    private String telephone;

    @NotBlank
    private String adresse;
}