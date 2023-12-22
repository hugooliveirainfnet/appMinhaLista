package com.minhalista.appMinhaLista.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "integrantes")
public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "grupoId")
    private Grupo grupo;

    private LocalDateTime dataAdicao;

    public Integrante(Usuario usuario, Grupo grupo) {
        this.usuario = usuario;
        this.grupo = grupo;
        this.dataAdicao = LocalDateTime.now();
    }

}
