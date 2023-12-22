package com.minhalista.appMinhaLista.dto.item;

import com.minhalista.appMinhaLista.dto.produto.ProdutoDto;
import com.minhalista.appMinhaLista.model.domain.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemOutputDto {

    private Integer id;
    private Integer quantidade;
    private Double valorTotal;
    private ProdutoDto produto;

    public static ItemOutputDto converter2Dto(Item i) {
        ItemOutputDto dto = new ItemOutputDto();
        dto.setId(i.getId());
        dto.setQuantidade(i.getQuantidade());
        dto.setValorTotal(i.getValorTotal());
        dto.setProduto(ProdutoDto.converter2Dto(i.getProduto()));
        return dto;
    }
    public static List<ItemOutputDto> converter2ListDto(List<Item> itens) {
        List<ItemOutputDto> dtos = new ArrayList<>();
        for (Item i : itens) {
            dtos.add(ItemOutputDto.converter2Dto(i));
        }
        return dtos;
    }
}
