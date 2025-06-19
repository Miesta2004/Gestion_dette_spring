package com.example.examen.services;

import java.util.List;

public interface IService <T>{
    T create(T objet);
    T getById(Long id);
    List<T> getAll();
}
