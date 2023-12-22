package com.minhalista.appMinhaLista.dto.lista;

import com.minhalista.appMinhaLista.dto.item.ItemOutputDto;
import com.minhalista.appMinhaLista.model.domain.Lista;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListaOutputDto {

    private Integer id;
    private String nome;
    private String imagem;
    private String descricao;
    private Double valorTotal;
    private List<ItemOutputDto> itens;

    public static ListaOutputDto converter2Dto(Lista l){
        ListaOutputDto dto = new ListaOutputDto();
        dto.setId(l.getId());
        dto.setNome(l.getNome());
        dto.setImagem(l.getImagem());
        dto.setDescricao(l.getDescricao());
        dto.setValorTotal(l.getValorTotal());
        dto.itens = ItemOutputDto.converter2ListDto(l.getItens());
        return dto;
    }

    public static List<ListaOutputDto> converter2ListDto(List<Lista> Listas){
        List<ListaOutputDto> dtos = new ArrayList<>();
        for (Lista l : Listas) {
            dtos.add(ListaOutputDto.converter2Dto(l));
        }
        return dtos;
    }
}
