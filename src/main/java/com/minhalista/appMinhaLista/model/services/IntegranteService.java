package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.model.domain.Integrante;
import com.minhalista.appMinhaLista.model.repositories.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class IntegranteService {

    @Autowired
    private IntegranteRepository integranteRepository;

    public void incluir(Integrante integrante) {
        integranteRepository.save(integrante);
    }

    public Collection<Integrante> listar() {
        return (Collection<Integrante>) integranteRepository.findAll();
    }

    public Optional<Integrante> buscar(Integer id) {
       return integranteRepository.findById(id);
    }
}
