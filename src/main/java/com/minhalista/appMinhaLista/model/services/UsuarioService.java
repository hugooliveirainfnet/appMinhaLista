package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.model.domain.Integrante;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import com.minhalista.appMinhaLista.model.repositories.IntegranteRepository;
import com.minhalista.appMinhaLista.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario incluir(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Collection<Usuario> listar() {
        return (Collection<Usuario>) usuarioRepository.findAll();
    }

    public Optional<Usuario> buscar(Integer id) {
       return usuarioRepository.findById(id);
    }
}
