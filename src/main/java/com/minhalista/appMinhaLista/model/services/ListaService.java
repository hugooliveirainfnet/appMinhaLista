package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.dto.lista.ListaInputDto;

import com.minhalista.appMinhaLista.model.domain.Lista;
import com.minhalista.appMinhaLista.model.repositories.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;


@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public Lista criar(Lista lista) {
        return listaRepository.save(lista);
    }
    public Collection<Lista> listar(Integer grupoId) {
        Collection<Lista> listas = (Collection<Lista>) listaRepository.findAllByGrupoId(grupoId);
        for (Lista lista: listas) {
            lista.calcularValorTotalLista();
        }
        return listas;

    }
    public Lista buscar(Integer grupoId, Integer listaId) {
        Lista lista = listaRepository.findByIdAndGrupoId(grupoId, listaId).get();
        lista.calcularValorTotalLista();
        return lista;
    }
    public Lista buscar(Integer listaId) {
        Lista lista = listaRepository.findById(listaId).get();
        lista.calcularValorTotalLista();
        return lista;
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
