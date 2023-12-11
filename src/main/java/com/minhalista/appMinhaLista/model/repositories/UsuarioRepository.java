package com.minhalista.appMinhaLista.model.repositories;

import com.minhalista.appMinhaLista.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}
