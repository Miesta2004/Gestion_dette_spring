package com.example.examen.data.repositories;

import com.example.examen.data.entites.Paiement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    Page<Paiement> findByDette_IdAndDette_Client_TelephoneContaining(Long detteId, String telephone, Pageable pageable);
}
