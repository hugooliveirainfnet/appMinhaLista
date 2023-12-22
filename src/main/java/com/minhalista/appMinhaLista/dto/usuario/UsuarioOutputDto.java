package com.minhalista.appMinhaLista.dto.usuario;

import com.minhalista.appMinhaLista.dto.grupo.GrupoOutputDto;
import com.minhalista.appMinhaLista.model.domain.Endereco;
import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UsuarioOutputDto {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String foto;
    private Endereco endereco;
    private List<GrupoOutputDto> grupos = new ArrayList<>();

    public static UsuarioOutputDto converter2Dto(Usuario usuario) {
        UsuarioOutputDto dto = new UsuarioOutputDto();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());
        dto.setFoto(usuario.getFoto());
        dto.setEndereco(usuario.getEndereco());

        for (Grupo grupo: usuario.getGrupos() ) {
            grupo.getIntegrantes().clear();
            dto.grupos.add(GrupoOutputDto.converter2Dto(grupo));

        }
        return dto;
    }

    public static List<UsuarioOutputDto> converter2ListDto(List<Usuario> usuarios) {
        List<UsuarioOutputDto> dtos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            dtos.add(UsuarioOutputDto.converter2Dto(usuario));
        }
        return dtos;
    }
}
