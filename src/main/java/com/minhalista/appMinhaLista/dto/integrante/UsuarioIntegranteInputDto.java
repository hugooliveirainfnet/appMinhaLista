package com.minhalista.appMinhaLista.dto.integrante;

import com.minhalista.appMinhaLista.dto.usuario.UsuarioInputDto;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioIntegranteInputDto {
    private Integer id;
    private String nome;

    public static Usuario converter2Model(UsuarioIntegranteInputDto dto) {
        Usuario model = new Usuario();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        return model;
    }
}
