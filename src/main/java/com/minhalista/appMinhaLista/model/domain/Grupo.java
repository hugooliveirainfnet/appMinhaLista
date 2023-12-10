package com.minhalista.appMinhaLista.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @ManyToMany(mappedBy = "grupos")
    private List<Usuario> usuarios;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "grupoId")
    private List<Lista> listas;
    private LocalDateTime dataCriacao;

    public Grupo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
    }
    public Grupo(Integer id, String nome, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
    }

//    public void setUsuario(Usuario usuario) {
//        this.usuarios.add(usuario);
//    }
//
//    public void setLista(Lista lista) { this.listas.add(lista); }

//    @Override
//    public String toString() {
//        List<String> participantes = usuarios.stream()
//                .map(Usuario::getNome) // Extrai o nome de cada Grupo
//                .collect(Collectors.toList());
//
//        List<String> nomelistas = listas.stream()
//                .map(Lista::getNome) // Extrai o nome de cada Grupo
//                .collect(Collectors.toList());
//
//        return String.format("nome (%s) - imagem (%s) - dataCriacao (%s) - participantes (%s) - listas (%s)",
//                nome, imagem, dataCriacao, participantes, nomelistas);
//    }
}
