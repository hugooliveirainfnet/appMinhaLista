package com.minhalista.appMinhaLista.dto.item;

import com.minhalista.appMinhaLista.dto.produto.ProdutoDto;
import com.minhalista.appMinhaLista.model.domain.Item;
import com.minhalista.appMinhaLista.model.domain.Lista;
import com.minhalista.appMinhaLista.model.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemInputDto {

    private Integer id;
    private Integer quantidade;
    private Integer produtoId;
    private ProdutoDto Produto;

}
