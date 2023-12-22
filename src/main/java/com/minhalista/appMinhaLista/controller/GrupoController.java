package com.minhalista.appMinhaLista.controller;

import com.minhalista.appMinhaLista.dto.grupo.GrupoInputDto;
import com.minhalista.appMinhaLista.dto.grupo.GrupoDetalheOutputDto;
import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @PostMapping("/{usuarioId}/grupos")
    public ResponseEntity<GrupoDetalheOutputDto> criarGrupo(
            @PathVariable("usuarioId") Integer usuarioId,
            @RequestBody GrupoInputDto inputDto) {

        Grupo novoGrupo = grupoService.criar(usuarioId, inputDto);
        GrupoDetalheOutputDto outputDto = GrupoDetalheOutputDto.converter2Dto(novoGrupo);
        return new ResponseEntity<GrupoDetalheOutputDto>(outputDto, HttpStatus.CREATED);
    }

    @GetMapping("/{usuarioId}/grupos")
    public ResponseEntity<List<GrupoDetalheOutputDto>> listarGrupos(@PathVariable("usuarioId") Integer usuarioId) {
        var grupos = (List<Grupo>) grupoService.listar(usuarioId);
        List<GrupoDetalheOutputDto> outputDtos = GrupoDetalheOutputDto.converter2ListDto(grupos);
        return ResponseEntity.ok(outputDtos);
    }

    @GetMapping("/grupos/{grupoId}")
    public ResponseEntity<GrupoDetalheOutputDto> obterGrupo(@PathVariable("grupoId") Integer grupoId) {
        Grupo grupo = grupoService.buscar(grupoId);
        GrupoDetalheOutputDto outputDto = GrupoDetalheOutputDto.converter2Dto(grupo);
        return ResponseEntity.ok(outputDto);
    }

    @PutMapping("/grupos")
    public ResponseEntity<GrupoDetalheOutputDto> atualizarGrupo(@RequestBody GrupoInputDto inputDto) {
        Grupo grupo = grupoService.atualizar(inputDto);
        GrupoDetalheOutputDto outputDto = GrupoDetalheOutputDto.converter2Dto(grupo);
        return ResponseEntity.ok(outputDto);
    }

    @DeleteMapping("/grupos/{grupoId}")
    public void excluirGrupo(@PathVariable("grupoId") Integer grupoId) {
        grupoService.excluir(grupoId);
    }
}
