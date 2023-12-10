package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Item;
import com.minhalista.appMinhaLista.model.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void incluir(Item item) {
        itemRepository.save(item);
    }

    public Collection<Item> listar() {
        return (Collection<Item>) itemRepository.findAll();
    }

    public Optional<Item> buscar(Integer id) {
        return itemRepository.findById(id);
    }
}
