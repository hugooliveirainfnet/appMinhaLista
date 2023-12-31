package com.minhalista.appMinhaLista.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String imagem;
    private String descricao;
    private Double preco;

    @ManyToMany(mappedBy = "produtos")
    private List<Lista> listas;

    private LocalDateTime dataCadastro;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
        this.dataCadastro = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("nome (%s) - preco (%.2f)", nome, preco);
    }
}
