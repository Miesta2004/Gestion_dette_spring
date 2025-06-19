package com.example.examen.services;

import com.example.examen.data.entites.Paiement;
import com.example.examen.web.dtos.request.PaiementRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPaiementService extends IService<Paiement> {
    Paiement create(Long detteId, PaiementRequestDTO dto);
    Page<Paiement> getByDette(Long detteId, Pageable pageable);
    Page<Paiement> getByClientTelephone(String telephone, Pageable pageable);
    Page<Paiement> getByDetteNumeroAndTelephone(Long detteId, String telephone, Pageable pageable);
}
