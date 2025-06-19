package com.example.examen.services;

import com.example.examen.data.entites.Dette;

public interface IDetteService extends IService<Dette> {
    Dette create(Long clientId, DetteRequestDTO dto);
    Page<Dette> getDettesByClient(Long clientId, Pageable pageable);
    Page<Dette> getDettesByClientTelephone(String telephone, Pageable pageable);
}
