package com.minhalista.appMinhaLista.model.service;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Participante;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParticipanteService {

    private Map<Integer, Participante> mapa = new HashMap<Integer, Participante>();

    public void incluir(Participante participante) { mapa.put(participante.getId(), participante); }
    public Collection<Participante> listar() { return mapa.values(); }
    public Participante buscar(Integer id) {
       return mapa.get(id);
    }
}
