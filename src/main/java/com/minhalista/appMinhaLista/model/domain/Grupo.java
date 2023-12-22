package com.minhalista.appMinhaLista.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String imagem;

    @ManyToMany(mappedBy = "grupos", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Integrante> integrantes = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "grupoId")
    private List<Lista> listas = new ArrayList<>();
    private LocalDateTime dataCriacao;

    public Grupo(String nome, Usuario usuario) {
        this.nome = nome;
        this.setIntegrante(new Integrante(usuario, this));
        this.dataCriacao = LocalDateTime.now();
    }

    public void setUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void setIntegrante(Integrante integrante) {
        this.integrantes.add(integrante);
    }

    public void setLista(Lista lista) { this.listas.add(lista); }

    @Override
    public String toString() {
        List<String> participantes = usuarios.stream()
                .map(Usuario::getNome) // Extrai o nome de cada Grupo
                .collect(Collectors.toList());


        return String.format("nome (%s) - imagem (%s) - dataCriacao (%s) - participantes (%s)",
                nome, imagem, dataCriacao, participantes);
    }
}
