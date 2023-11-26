package com.minhalista.appMinhaLista.model.service;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Participante;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GrupoService {
    private Map<Integer, Grupo> mapa = new HashMap<Integer, Grupo>();

    public void incluir(Grupo grupo) {
        mapa.put(grupo.getId(), grupo);
    }

    public Collection<Grupo> listar() {
        return mapa.values();
    }
    public Grupo buscar(Integer id) { return mapa.get(id); }
}
