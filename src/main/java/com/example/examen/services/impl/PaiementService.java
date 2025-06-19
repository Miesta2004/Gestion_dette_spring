package com.example.examen.services.impl;

import com.example.examen.data.entites.Dette;
import com.example.examen.data.entites.Paiement;
import com.example.examen.data.repositories.DetteRepository;
import com.example.examen.data.repositories.PaiementRepository;
import com.example.examen.services.IPaiementService;
import com.example.examen.web.dtos.request.PaiementRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PaiementService implements IPaiementService {

    private final PaiementRepository paiementRepository;
    private final DetteRepository detteRepository;

    public PaiementService(PaiementRepository paiementRepository, DetteRepository detteRepository) {
        this.paiementRepository = paiementRepository;
        this.detteRepository = detteRepository;
    }

    @Override
    public Paiement create(PaiementRequestDTO dto) {
        Dette dette = detteRepository.findById(dto.getDetteId())
                .orElseThrow(() -> new RuntimeException("Dette not found"));

        Paiement paiement = new Paiement();
        paiement.setMontant(dto.getMontant());
        paiement.setDate(dto.getDate());
        paiement.setDette(dette);

        // mise à jour montant payé et restant
        double nouveauMontantPaye = dette.getMontantPaye() + dto.getMontant();
        double nouveauMontantRestant = dette.getMontantDette() - nouveauMontantPaye;

        dette.setMontantPaye(nouveauMontantPaye);
        dette.setMontantRestant(nouveauMontantRestant);
        detteRepository.save(dette);

        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    @Override
    public List<Paiement> findByClientTelephone(String telephone) {
        return paiementRepository.findByDette_Client_TelephoneContainsIgnoreCase(telephone);
    }

    @Override
    public List<Paiement> findByDetteNumero(Long detteId) {
        return paiementRepository.findByDette_Id(detteId);
    }
}
