package com.example.examen.data.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Dette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String date; // Tu peux utiliser `LocalDate` pour plus de rigueur

    @NotNull
    private Double montantDette;

    @NotNull
    private Double montantPaye = 0.0;

    @NotNull
    private Double montantRestant = 0.0;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "dette", cascade = CascadeType.ALL)
    private List<Paiement> paiements = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void calculMontantRestant() {
        montantPaye = paiements.stream().mapToDouble(Paiement::getMontantDette).sum();
        montantRestant = montantDette - montantPaye;
    }
}

