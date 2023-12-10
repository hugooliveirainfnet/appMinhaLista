package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.model.domain.Item;
import com.minhalista.appMinhaLista.model.domain.Lista;
import com.minhalista.appMinhaLista.model.repositories.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public void incluir(Lista lista) {
        listaRepository.save(lista);
    }

    public Collection<Lista> listar() {
        return (Collection<Lista>) listaRepository.findAll();
    }

    public Optional<Lista> buscar(Integer id) {
        return listaRepository.findById(id);
    }
}
