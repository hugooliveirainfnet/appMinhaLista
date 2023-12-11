package com.minhalista.appMinhaLista.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "listas")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String imagem;
    @ManyToOne
    @JoinColumn(name = "grupoId")
    private Grupo grupo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "itens",
            joinColumns = @JoinColumn(name = "listaId"),
            inverseJoinColumns = @JoinColumn(name = "produtoId")
    )
    private List<Produto> produtos;

    @OneToMany(mappedBy = "lista", fetch = FetchType.EAGER)
    private List<Item> itens = new ArrayList<Item>();
    private LocalDateTime dataCriacao;

    public Lista(String nome, Grupo grupo) {
        this.nome = nome;
        this.grupo = grupo;
        this.dataCriacao = LocalDateTime.now();
    }

    public Double calcularValorTotalLista() {
        Double valorTotal = 0.0;
        for (Item item : itens) {
            Double valorItem = item.getProduto().getPreco();
            int quantidade = item.getQuantidade();
            valorTotal += valorItem * quantidade;
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return String.format("nome (%s) - grupo (%s)",
                nome, grupo.getNome());
    }
}
