package com.minhalista.appMinhaLista.dto.grupo;

import com.minhalista.appMinhaLista.dto.integrante.IntegranteInputDto;
import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoInputDto {

    private Integer id;
    private String nome;
    private String imagem;


}
