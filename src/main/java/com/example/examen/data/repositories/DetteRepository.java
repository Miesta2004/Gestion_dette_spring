package com.example.examen.data.repositories;

import com.example.examen.data.entites.Dette;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetteRepository extends JpaRepository<Dette, Long> {
    Page<Dette> findByClient_TelephoneContains(String telephone, Pageable pageable);
}