package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.model.domain.Produto;
import com.minhalista.appMinhaLista.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluir(Produto produto) {
        produtoRepository.save(produto);
    }

    public Collection<Produto> listar() {
        return (Collection<Produto>) produtoRepository.findAll();
    }

    public Optional<Produto> buscar(Integer id) {
        return produtoRepository.findById(id);
    }
}
