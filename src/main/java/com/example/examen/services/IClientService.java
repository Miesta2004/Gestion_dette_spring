package com.example.examen.services;

import com.example.examen.data.entites.Client;
import com.example.examen.web.dtos.request.ClientRequestDTO;

public interface IClientService extends IService<Client> {
   package com.example.examen.services;

import com.example.examen.data.entites.Client;
import com.example.examen.web.dtos.request.ClientRequestDTO;

import java.util.List;

    public interface IClientService extends IService<Client>{
        Client create(ClientRequestDTO dto);
        Client create(Client client);
        Client getById(Long id);
        List<Client> getAll();
        Client findByTelephone(String telephone);
    }


}
