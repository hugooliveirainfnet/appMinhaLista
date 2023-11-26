package com.minhalista.appMinhaLista.model.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lista {

    private Integer id;
    private String nome;
    private String imagem;
    private Grupo grupo;
    private List<Item> itens = new ArrayList<Item>();
    private LocalDateTime dataCriacao;

    public Lista(Integer id, String nome, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.grupo = grupo;
        this.dataCriacao = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItem(Item item) {
        this.itens.add(item);
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return String.format("nome (%s) - grupo (%s) - itens (%s)",
                nome, grupo.getNome(), itens);
    }
}
