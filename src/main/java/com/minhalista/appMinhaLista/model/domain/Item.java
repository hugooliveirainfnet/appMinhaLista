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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produtoId")
    private Produto produto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listaId")
    private Lista lista;

    public Item(Integer quantidade, Double valorTotal, Produto produto, Lista lista) {
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.lista = lista;
    }

    @Override
    public String toString() {
        return String.format("produto (%s) - quantidade (%d) - valorTotal (%.2f) - lista (%s)",
                produto.getNome(), quantidade, valorTotal, lista.getNome());
    }
}
