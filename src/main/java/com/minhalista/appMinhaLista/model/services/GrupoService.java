package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.dto.grupo.GrupoInputDto;
import com.minhalista.appMinhaLista.dto.integrante.IntegranteInputDto;
import com.minhalista.appMinhaLista.dto.integrante.UsuarioIntegranteInputDto;
import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Integrante;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import com.minhalista.appMinhaLista.model.repositories.GrupoRepository;
import com.minhalista.appMinhaLista.model.repositories.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GrupoService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private IntegranteRepository integranteRepository;

    public Grupo criar(Integer usuarioId, GrupoInputDto inputDto) {
        Usuario integrante = usuarioService.buscar(usuarioId);
        Grupo novoGrupo = new Grupo(inputDto.getNome(), integrante);
        return grupoRepository.save(novoGrupo);
    }
    public Grupo incluirIntegrante(Integer grupoId, IntegranteInputDto inputDto){
        Usuario novoIntegrante = null;
        Grupo grupo = grupoRepository.findById(grupoId).get();
        try{
            novoIntegrante = usuarioService.buscar(inputDto.getUsuarioId());
        }catch (RuntimeException e){
            if (e instanceof IllegalArgumentException || e instanceof InvalidDataAccessApiUsageException) {
                throw new RuntimeException("Um produto deve ser informado");
            } else if (e instanceof NoSuchElementException) {
                novoIntegrante = UsuarioIntegranteInputDto.converter2Model(inputDto.getUsuario());
            }
        }finally {
            grupo.setIntegrante(new Integrante(novoIntegrante, grupo));
            return grupoRepository.save(grupo);
        }
    }

    public Collection<Grupo> listar(Integer usuarioId) {
        Collection<Grupo> grupos = new ArrayList<>();
        List<Integrante> integrantes = (List<Integrante>) integranteRepository.findAllByUsuarioId(usuarioId);

        for (Integrante integrante: integrantes) {
            grupos.add(integrante.getGrupo());
        }
        return grupos;
    }

    public Collection<Grupo> listar() {
        return (Collection<Grupo>) grupoRepository.findAll();
    }

    public Grupo buscar(Integer id) {
        return grupoRepository.findById(id).get();
    }

    public Grupo atualizar(GrupoInputDto atualizacaoGrupo) {
        Grupo grupo = grupoRepository.findById(atualizacaoGrupo.getId()).get();
        grupo.setNome(atualizacaoGrupo.getNome());
        grupo.setImagem(atualizacaoGrupo.getImagem());
        return grupoRepository.save(grupo);
    }

    public void excluir(Integer id) {
        grupoRepository.deleteById(id);
    }
}
