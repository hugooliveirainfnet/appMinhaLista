package com.minhalista.appMinhaLista.dto.produto;

import com.minhalista.appMinhaLista.model.domain.Produto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProdutoDto {

    private Integer id;
    private String nome;
    private String imagem;
    private String descricao;
    private Double preco;

    public static ProdutoDto converter2Dto(Produto p){
        ProdutoDto dto = new ProdutoDto();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setImagem(p.getImagem());
        dto.setPreco(p.getPreco());
        dto.setDescricao(p.getDescricao());
        return dto;
    }
    public static List<ProdutoDto> converter2ListDto(List<Produto> produtos){
        List<ProdutoDto> dtos = new ArrayList<>();
        for (Produto p : produtos) {
            dtos.add(converter2Dto(p));
        }
        return dtos;
    }
    public static Produto converter2Model(ProdutoDto dto){
        Produto p = new Produto(dto.getNome(), dto.getPreco());
        p.setId(dto.getId());
        p.setImagem(dto.getImagem());
        p.setDescricao(dto.getDescricao());
        return p;
    }
}
