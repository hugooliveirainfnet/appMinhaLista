package com.minhalista.appMinhaLista.model.repositories;

import com.minhalista.appMinhaLista.model.domain.Integrante;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface IntegranteRepository extends CrudRepository<Integrante, Integer> {

    public Iterable<Integrante> findAllByUsuarioId(Integer usuarioId);
}
