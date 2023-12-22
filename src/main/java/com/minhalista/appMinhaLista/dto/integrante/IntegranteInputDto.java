package com.minhalista.appMinhaLista.dto.integrante;

import com.minhalista.appMinhaLista.dto.usuario.UsuarioInputDto;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteInputDto {
    private Integer id;
    private Integer usuarioId;
    private Integer grupoId;
    private UsuarioIntegranteInputDto usuario;
}
