package com.minhalista.appMinhaLista.model.repositories;

import com.minhalista.appMinhaLista.model.domain.Lista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ListaRepository extends CrudRepository<Lista, Integer> {

    public List<Lista> findAllByGrupoId(Integer grupoId);
    Optional<Lista> findByIdAndGrupoId(Integer grupoId, Integer listaId);
}
