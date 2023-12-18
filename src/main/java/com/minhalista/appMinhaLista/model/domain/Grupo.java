package com.minhalista.appMinhaLista.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(mappedBy = "grupos", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "grupoId")
    @JsonIgnore
    private List<Lista> listas;
    private LocalDateTime dataCriacao;

    public Grupo(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuarios.add(usuario);
        this.dataCriacao = LocalDateTime.now();
    }

    public void setUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
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
