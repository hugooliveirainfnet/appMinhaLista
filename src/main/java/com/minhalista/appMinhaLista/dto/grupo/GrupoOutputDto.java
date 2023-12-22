package com.minhalista.appMinhaLista.dto.grupo;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GrupoOutputDto {

    private Integer id;
    private String nome;
    private String imagem;
    private LocalDateTime dataCriacao;

    public static GrupoOutputDto converter2Dto(Grupo grupo) {
        GrupoOutputDto dto = new GrupoOutputDto();
        dto.setId(grupo.getId());
        dto.setNome(grupo.getNome());
        dto.setImagem(grupo.getImagem());
        dto.setDataCriacao(grupo.getDataCriacao());
        return dto;
    }
    public static List<GrupoOutputDto> converter2ListDto(List<Grupo> grupos) {
        List<GrupoOutputDto> dtos = new ArrayList<>();
        for (Grupo grupo : grupos) {
            dtos.add(GrupoOutputDto.converter2Dto(grupo));
        }
        return dtos;
    }
}
