package com.minhalista.appMinhaLista.controller;

import com.minhalista.appMinhaLista.dto.usuario.UsuarioInputDto;
import com.minhalista.appMinhaLista.dto.usuario.UsuarioOutputDto;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import com.minhalista.appMinhaLista.model.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioOutputDto> criarUsuario(@RequestBody UsuarioInputDto inputDto) {
        Usuario novoUsuario = usuarioService.criar(inputDto);
        UsuarioOutputDto outputDto = UsuarioOutputDto.converter2Dto(novoUsuario);
        return new ResponseEntity<UsuarioOutputDto>(outputDto, HttpStatus.CREATED);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioOutputDto>> listarUsuarios() {
        var usuarios = (List<Usuario>) usuarioService.listar();
        List<UsuarioOutputDto> outputDtos = UsuarioOutputDto.converter2ListDto(usuarios);
        return ResponseEntity.ok(outputDtos);
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioOutputDto> obterUsuarios(@PathVariable("usuarioId") Integer usuarioId) {
        Usuario usuario = usuarioService.buscar(usuarioId);
        UsuarioOutputDto outputDto = UsuarioOutputDto.converter2Dto(usuario);
        return ResponseEntity.ok(outputDto);
    }

     @PutMapping("/usuarios")
     public ResponseEntity<UsuarioOutputDto> atualizarUsuario(@RequestBody UsuarioInputDto inputDto) {
        Usuario usuarioAtualizado = usuarioService.atualizar(inputDto);
        UsuarioOutputDto outputDto = UsuarioOutputDto.converter2Dto(usuarioAtualizado);
        return ResponseEntity.ok(outputDto);
     }

    @DeleteMapping("/usuarios/{usuarioId}")
    public void excluirUsuario(@PathVariable("usuarioId") Integer usuarioId) {
        usuarioService.excluir(usuarioId);
    }
}
