package com.minhalista.appMinhaLista.model.service;

import com.minhalista.appMinhaLista.model.domain.Item;
import com.minhalista.appMinhaLista.model.domain.Participante;
import com.minhalista.appMinhaLista.model.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {

    private Map<Integer, Item> mapa = new HashMap<Integer, Item>();

    public void incluir(Item item) {
        mapa.put(item.getProduto().getId(), item);
    }
    public Collection<Item> listar() {
        return mapa.values();
    }
}
