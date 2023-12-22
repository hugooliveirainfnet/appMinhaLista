package com.minhalista.appMinhaLista.model.repositories;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GrupoRepository extends CrudRepository<Grupo, Integer> {
}
