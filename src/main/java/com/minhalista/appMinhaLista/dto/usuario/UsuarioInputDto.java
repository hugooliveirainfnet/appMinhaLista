package com.minhalista.appMinhaLista.dto.usuario;

import com.minhalista.appMinhaLista.dto.grupo.GrupoInputDto;
import com.minhalista.appMinhaLista.model.domain.Endereco;
import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UsuarioInputDto {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String foto;
    private String cep;

    public static Usuario converter2Model(UsuarioInputDto dto) {
        Usuario model = new Usuario();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setTelefone(dto.getTelefone());
        model.setFoto(dto.getFoto());
        return model;
    }

}
