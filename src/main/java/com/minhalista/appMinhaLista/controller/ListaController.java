package com.minhalista.appMinhaLista.controller;

import com.minhalista.appMinhaLista.dto.lista.ListaInputDto;
import com.minhalista.appMinhaLista.dto.lista.ListaOutputDto;
import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Lista;
import com.minhalista.appMinhaLista.model.services.GrupoService;
import com.minhalista.appMinhaLista.model.services.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grupos")
public class ListaController {

    @Autowired
    GrupoService grupoService;
    @Autowired
    ListaService listaService;

    @PostMapping("/{grupoId}/listas")
    public ResponseEntity<ListaOutputDto> criarLista(@PathVariable("grupoId") Integer grupoId, @RequestBody ListaInputDto inputDto) {
        Grupo grupo = grupoService.buscar(grupoId);
        Lista novaLista = ListaInputDto.converter2Model(grupo, inputDto);
        Lista listaIncluida = listaService.criar(novaLista);
        ListaOutputDto outputDto = ListaOutputDto.converter2Dto(listaIncluida);
        return new ResponseEntity<ListaOutputDto>(outputDto, HttpStatus.CREATED);
    }

    @GetMapping("/{grupoId}/listas")
    public ResponseEntity<List<ListaOutputDto>> listarListas(@PathVariable("grupoId") Integer grupoId) {
        List<Lista> listas = (List<Lista>) listaService.listar(grupoId);
        List<ListaOutputDto> outputDtos = ListaOutputDto.converter2ListDto(listas);
        return ResponseEntity.ok(outputDtos);
    }

    @GetMapping("/listas/{listaId}")
    public ResponseEntity<ListaOutputDto> obterLista(@PathVariable("listaId") Integer listaId) {
        Lista lista = listaService.buscar(listaId);
        ListaOutputDto outputDto = ListaOutputDto.converter2Dto(lista);
        return ResponseEntity.ok(outputDto);
    }

    @PutMapping("/listas")
    public ResponseEntity<ListaOutputDto> atualizarLista(@RequestBody ListaInputDto inputDto) {
        Lista ListaAtualizada = listaService.atualizar(inputDto);
        ListaOutputDto outputDto = ListaOutputDto.converter2Dto(ListaAtualizada);
        return ResponseEntity.ok(outputDto);
    }

    @DeleteMapping("/listas/{listaId}")
    public void excluirLista(@PathVariable("listaId") Integer listaId) {
        listaService.excluir(listaId);
    }
}
