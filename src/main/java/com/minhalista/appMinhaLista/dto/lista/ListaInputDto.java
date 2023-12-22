package com.minhalista.appMinhaLista.dto.lista;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Lista;
import lombok.Data;

@Data
public class ListaInputDto {

    private Integer id;
    private String nome;
    private String imagem;
    private String descricao;

    public static Lista converter2Model(Grupo grupo, ListaInputDto dto){
        Lista l = new Lista(dto.getNome(), grupo);
        l.setId(dto.getId());
        l.setImagem(dto.getImagem());
        l.setDescricao(dto.getDescricao());
        return l;
    }
}
