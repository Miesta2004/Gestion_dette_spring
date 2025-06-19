package com.example.examen.data.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nom;

    @NotBlank
    private String telephone;

    @NotBlank
    private String adresse;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Dette> dettes = new ArrayList<>();

}

