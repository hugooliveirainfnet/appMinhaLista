package com.minhalista.appMinhaLista.controller;

import com.minhalista.appMinhaLista.dto.grupo.GrupoDetalheOutputDto;
import com.minhalista.appMinhaLista.dto.integrante.IntegranteInputDto;
import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/grupos")
public class IntegranteController {

    @Autowired
    GrupoService grupoService;

    @PostMapping("/{grupoId}/integrantes")
    public ResponseEntity<GrupoDetalheOutputDto> incluirIntegrante(
            @PathVariable("grupoId") Integer grupoId,
            @RequestBody IntegranteInputDto inputDto) {

        Grupo grupo = grupoService.incluirIntegrante(grupoId, inputDto);
        GrupoDetalheOutputDto outputDto = GrupoDetalheOutputDto.converter2Dto(grupo);
        return new ResponseEntity<GrupoDetalheOutputDto>(outputDto, HttpStatus.CREATED);
    }

}
