package com.minhalista.appMinhaLista.dto.grupo;

import com.minhalista.appMinhaLista.dto.integrante.IntegranteOutputDto;
import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Integrante;
import com.minhalista.appMinhaLista.model.domain.Lista;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GrupoDetalheOutputDto {

    private Integer id;
    private String nome;
    private String imagem;
    private LocalDateTime dataCriacao;
    private List<IntegranteOutputDto> integrantes = new ArrayList<>();
    private List<ListaOutputDto> listas = new ArrayList<>();


    public static GrupoDetalheOutputDto converter2Dto(Grupo grupo) {
        GrupoDetalheOutputDto dto = new GrupoDetalheOutputDto();
        dto.setId(grupo.getId());
        dto.setNome(grupo.getNome());
        dto.setImagem(grupo.getImagem());
        dto.setDataCriacao(grupo.getDataCriacao());

        for (Integrante integrante: grupo.getIntegrantes() ) {
            dto.integrantes.add(IntegranteOutputDto.converter2Dto(integrante));
        }
        for (Lista lista : grupo.getListas()) {
            dto.listas.add(ListaOutputDto.converter2Dto(lista));
        }
        return dto;
    }
    public static List<GrupoDetalheOutputDto> converter2ListDto(List<Grupo> grupos) {
        List<GrupoDetalheOutputDto> dtos = new ArrayList<>();

        for (Grupo grupo : grupos) {
            dtos.add(GrupoDetalheOutputDto.converter2Dto(grupo));
        }
        return dtos;
    }


}
