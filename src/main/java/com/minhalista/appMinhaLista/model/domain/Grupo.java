package com.minhalista.appMinhaLista.model.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grupo {

    private Integer id;
    private String nome;
    private String imagem;
    private List<Participante> participantes = new ArrayList<Participante>();
    private Map<Integer, LocalDateTime> dataAdicaoParticipante = new HashMap<Integer, LocalDateTime>();
    private List<Lista> listas = new ArrayList<Lista>();
    private LocalDateTime dataCriacao;

    public Grupo() {}
    public Grupo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
    }
    public Grupo(Integer id, String nome, Participante participante) {
        this.id = id;
        this.nome = nome;
        setParticipante(participante);
        setDataAdicaoParticipante(participante);
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

    public List<Participante> getParticipante() {
        return participantes;
    }
    public void setParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    public Map<Integer, LocalDateTime> getDataAdicaoParticipante() {
        return dataAdicaoParticipante;
    }
    public void setDataAdicaoParticipante(Participante participante, LocalDateTime dataInclusao) {
        this.dataAdicaoParticipante.put(participante.getId(), dataInclusao);
    }
    public void setDataAdicaoParticipante(Participante participante) {
        this.dataAdicaoParticipante.put(participante.getId(), LocalDateTime.now());
    }

    public List<Lista> getListas() {
        return listas;
    }
    public void setLista(Lista lista) {
        this.listas.add(lista);
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    private void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        List<String> nomeParticipantes = participantes.stream()
                .map(Participante::getNome) // Extrai o nome de cada Grupo
                .collect(Collectors.toList());

        List<String> nomelistas = listas.stream()
                .map(Lista::getNome) // Extrai o nome de cada Grupo
                .collect(Collectors.toList());

        return String.format("nome (%s) - imagem (%s) - dataCriacao (%s) - participantes (%s) - listas (%s)",
                nome, imagem, dataCriacao, nomeParticipantes, nomelistas);
    }
}
