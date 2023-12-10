package com.minhalista.appMinhaLista.model.repositories;

import com.minhalista.appMinhaLista.model.domain.Lista;
import org.springframework.data.repository.CrudRepository;

public interface ListaRepository extends CrudRepository<Lista, Integer> {
}
