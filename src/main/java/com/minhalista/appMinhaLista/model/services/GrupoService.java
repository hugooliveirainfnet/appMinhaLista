package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public Grupo incluir(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Collection<Grupo> listar() {
        return (Collection<Grupo>) grupoRepository.findAll();
    }

    public Optional<Grupo> buscar(Integer id) {
        return grupoRepository.findById(id);
    }
}
