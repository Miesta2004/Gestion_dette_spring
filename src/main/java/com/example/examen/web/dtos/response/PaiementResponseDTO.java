package com.example.examen.web.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiementResponseDTO {
    private Long id;
    private LocalDate date;
    private Double montant;
    private Long detteId;
    private String telephoneClient;
}
