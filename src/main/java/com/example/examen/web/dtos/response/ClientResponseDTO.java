package com.example.examen.web.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private Long id;
    private String nom;
    private String telephone;
    private String adresse;
}
