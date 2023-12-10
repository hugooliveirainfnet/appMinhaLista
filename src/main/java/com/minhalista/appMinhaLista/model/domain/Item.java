package com.minhalista.appMinhaLista.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidade;
    private Double valorTotal;
    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "listaId")
    private Lista lista;

    public Item(Integer quantidade, Double valorTotal, Produto produto) {
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.produto = produto;
    }

    @Override
    public String toString() {
        return String.format("produto (%s) - quantidade (%d) - valorTotal (%.2f)",
                produto.getNome(), quantidade, valorTotal);
    }
}
