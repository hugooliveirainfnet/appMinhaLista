package com.minhalista.appMinhaLista.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private  Integer id;
    private String nome;
    private String imagem;
    private String descricao;
    private Double preco;
    private LocalDateTime dataCadastro;

    @Override
    public String toString() {
        return String.format("nome (%s) - preco (%.2f) - descricao (%s) - dataCadastro (%s)",
                nome, preco, descricao, dataCadastro);
    }
}
