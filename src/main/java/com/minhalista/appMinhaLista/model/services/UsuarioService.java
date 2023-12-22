package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.dto.usuario.UsuarioInputDto;
import com.minhalista.appMinhaLista.model.domain.Endereco;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import com.minhalista.appMinhaLista.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoService enderecoService;

    public Usuario criar(UsuarioInputDto inputDto) {
        Endereco endereco = enderecoService.buscarCep(inputDto.getCep());
        Usuario usuario = UsuarioInputDto.converter2Model(inputDto);
        usuario.setEndereco(endereco);
        return usuarioRepository.save(usuario);
    }

    public Collection<Usuario> listar() {
        return (Collection<Usuario>) usuarioRepository.findAll();
    }

    public Usuario buscar(Integer id) {
       return usuarioRepository.findById(id).get();
    }

    public Usuario atualizar(UsuarioInputDto atualizacaoUsuario) {
        Usuario usuario = usuarioRepository.findById(atualizacaoUsuario.getId()).get();
        usuario.setNome(atualizacaoUsuario.getNome());
        usuario.setEmail(atualizacaoUsuario.getEmail());
        usuario.setTelefone(atualizacaoUsuario.getTelefone());
        return usuarioRepository.save(usuario);
    }

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
