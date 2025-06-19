package com.example.examen.data.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double montantDette;

    @NotBlank
    private String date;

    @ManyToOne
    private Dette dette;
}
