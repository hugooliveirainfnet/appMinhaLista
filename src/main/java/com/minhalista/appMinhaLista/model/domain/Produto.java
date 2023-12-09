package com.minhalista.appMinhaLista.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
