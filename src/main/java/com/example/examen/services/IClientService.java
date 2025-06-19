package com.example.examen.services;

import com.example.examen.data.entites.Client;
import com.example.examen.web.dtos.request.ClientRequestDTO;

public interface IClientService extends IService<Client> {
    Client create(ClientRequestDTO objet);

}
