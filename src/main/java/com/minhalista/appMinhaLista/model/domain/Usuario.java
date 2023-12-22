package com.minhalista.appMinhaLista.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String foto;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "integrantes",
            joinColumns = @JoinColumn(name = "usuarioId"),
            inverseJoinColumns = @JoinColumn(name = "grupoId")
    )
    private List<Grupo> grupos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "enderecoId")
    private Endereco endereco;
    private LocalDateTime dataCriacao;

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCriacao = LocalDateTime.now();
    }

    public void setGrupo(Grupo grupo) {
        this.grupos.add(grupo);
    }

    @Override
    public String toString() {
        return String.format("nome (%s) - email (%s) - telefone (%s) - foto (%s) - Endereco (%s)",
                nome, email, telefone, foto, endereco);
    }
}
