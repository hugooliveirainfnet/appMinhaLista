package com.minhalista.appMinhaLista.model.service;

import com.minhalista.appMinhaLista.model.domain.Participante;
import com.minhalista.appMinhaLista.model.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProdutoService {
    private Map<Integer, Produto> mapa = new HashMap<Integer, Produto>();

    public void incluir(Produto produto) {
        mapa.put(produto.getId(), produto);
    }
    public Collection<Produto> listar() {
        return mapa.values();
    }
    public Produto buscar(Integer id) {
        return mapa.get(id);
    }
}
