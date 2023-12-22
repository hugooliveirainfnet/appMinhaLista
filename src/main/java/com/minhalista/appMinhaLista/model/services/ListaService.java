package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.dto.lista.ListaInputDto;

import com.minhalista.appMinhaLista.model.domain.Lista;
import com.minhalista.appMinhaLista.model.repositories.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;


@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public Lista criar(Lista lista) {
        return listaRepository.save(lista);
    }
    public Collection<Lista> listar(Integer grupoId) {
        return (Collection<Lista>) listaRepository.findAllByGrupoId(grupoId);
    }
    public Lista buscar(Integer grupoId, Integer listaId) {
        return listaRepository.findByIdAndGrupoId(grupoId, listaId).get();
    }
    public Lista buscar(Integer listaId) {
        return listaRepository.findById(listaId).get();
    }

    public Lista atualizar(ListaInputDto atualizacaoLista) {
        Lista lista = listaRepository.findById(atualizacaoLista.getId()).get();
        lista.setNome(atualizacaoLista.getNome());
        lista.setImagem(atualizacaoLista.getImagem());
        lista.setDescricao(atualizacaoLista.getDescricao());
        return listaRepository.save(lista);
    }
    public void excluir(Integer id) {
        listaRepository.deleteById(id);
    }
}
