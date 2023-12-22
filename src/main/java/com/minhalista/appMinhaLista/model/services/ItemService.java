package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.dto.integrante.UsuarioIntegranteInputDto;
import com.minhalista.appMinhaLista.dto.item.ItemInputDto;
import com.minhalista.appMinhaLista.dto.item.QuantidadeItemInputDto;
import com.minhalista.appMinhaLista.dto.produto.ProdutoDto;
import com.minhalista.appMinhaLista.model.domain.*;
import com.minhalista.appMinhaLista.model.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ListaService listaService;

    public Item criar(Integer listaId, ItemInputDto inputDto) {
        Item novoItem = null;
        Lista lista = listaService.buscar(listaId);
        try{
            Produto produto = produtoService.buscar(inputDto.getProdutoId());
            novoItem =  new Item(inputDto.getQuantidade(), produto, lista);

        }catch (RuntimeException e){
            if (e instanceof IllegalArgumentException || e instanceof InvalidDataAccessApiUsageException) {
                throw new RuntimeException("Um produto deve ser informado");
            } else if (e instanceof NoSuchElementException) {
                Produto p = ProdutoDto.converter2Model(inputDto.getProduto());
                Produto produto = produtoService.criar(p);
                novoItem =  new Item(inputDto.getQuantidade(), produto, lista);
            }
        }finally {
            return itemRepository.save(novoItem);
        }
        
        
    }

    public Collection<Item> listar() {
        return (Collection<Item>) itemRepository.findAll();
    }

    public Optional<Item> buscar(Integer id) {
        return itemRepository.findById(id);
    }

    public Item atualizar(QuantidadeItemInputDto inputDto) {
        Item item = itemRepository.findById(inputDto.getId()).get();
        item.setQuantidade(inputDto.getQuantidade());
        return itemRepository.save(item);
    }

    public void excluir(Integer itemId){
        itemRepository.deleteById(itemId);
    }
}
