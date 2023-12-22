package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.model.domain.Produto;
import com.minhalista.appMinhaLista.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }
    public Collection<Produto> listar() {
        return (Collection<Produto>) produtoRepository.findAll();
    }
    public Produto buscar(Integer id) {
        return produtoRepository.findById(id).get();
    }
    public Produto atualizar(Produto atualizacaoProduto) {
        Produto produto = produtoRepository.findById(atualizacaoProduto.getId()).get();
        produto.setNome(atualizacaoProduto.getNome());
        produto.setImagem(atualizacaoProduto.getImagem());
        produto.setDescricao(atualizacaoProduto.getDescricao());
        produto.setPreco(atualizacaoProduto.getPreco());
        return produtoRepository.save(produto);
    }
    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }
}
