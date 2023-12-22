package com.minhalista.appMinhaLista.dto.integrante;

import com.minhalista.appMinhaLista.model.domain.Integrante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class IntegranteOutputDto {

    private Integer id;
    private String nome;
    private LocalDateTime dataInclusao;

    public static IntegranteOutputDto converter2Dto(Integrante integrante) {
        IntegranteOutputDto dto = new IntegranteOutputDto();
        dto.id = integrante.getId();
        dto.nome = integrante.getUsuario().getNome();
        dto.dataInclusao = integrante.getDataAdicao();
        return dto;
    }
}
