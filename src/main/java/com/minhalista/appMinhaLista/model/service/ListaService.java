package com.minhalista.appMinhaLista.model.service;

import com.minhalista.appMinhaLista.model.domain.Lista;
import com.minhalista.appMinhaLista.model.domain.Participante;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ListaService {

    private Map<Integer, Lista> mapa = new HashMap<Integer, Lista>();

    public void incluir(Lista lista) {
        mapa.put(lista.getGrupo().getId(), lista);
    }

    public Collection<Lista> listar() {
        return mapa.values();
    }
}
