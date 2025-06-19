package com.example.examen.data.repositories;

import com.example.examen.data.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByTelephone(String telephone);

}

