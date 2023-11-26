package com.minhalista.appMinhaLista.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participante {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String foto;
    private List<Grupo> grupos = new ArrayList<Grupo>();
    private LocalDateTime dataCriacao;

    public Participante(){}

    public Participante(Integer id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupo(Grupo grupo) {
        this.grupos.add(grupo);
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {

        List<String> nomesGrupos = grupos.stream()
                .map(Grupo::getNome) // Extrai o nome de cada Grupo
                .collect(Collectors.toList());

            return String.format("nome (%s) - email (%s) - telefone (%s) - foto (%s) - grupos (%s)",
                    nome, email, telefone, foto, nomesGrupos);

    }
}
