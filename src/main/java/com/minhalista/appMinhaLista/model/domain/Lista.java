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

    @ManyToMany
    @JoinTable(
            name = "itens",
            joinColumns = @JoinColumn(name = "listaId"),
            inverseJoinColumns = @JoinColumn(name = "produtoId")
    )
    private List<Produto> produtos;
    private LocalDateTime dataCriacao;

    public Lista(Integer id, String nome, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.grupo = grupo;
        this.dataCriacao = LocalDateTime.now();
    }

//    public void setItem(Item item) {
//        this.itens.add(item);
//    }

//    @Override
//    public String toString() {
//        return String.format("nome (%s) - grupo (%s) - itens (%s)",
//                nome, grupo.getNome(), itens);
//    }
}
