package com.minhalista.appMinhaLista.controller;

import com.minhalista.appMinhaLista.model.domain.Usuario;
import com.minhalista.appMinhaLista.model.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario criado = usuarioService.incluir(usuario);
        return new ResponseEntity<Usuario>(criado, HttpStatus.CREATED);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        var usuarios = (List<Usuario>) usuarioService.listar();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/usuarios/{id}")
    public Usuario obterUsuarios(@PathVariable("id") Integer id) {
        return usuarioService.buscar(id).get();
    }

     @PutMapping("/usuarios")
     public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.atualizar(usuario);
     }

    @DeleteMapping("/usuarios/{id}")
    public void excluirUsuarios(@PathVariable("id") Integer id) {
        usuarioService.excluir(id);
    }
}
