package com.minhalista.appMinhaLista.controller;

import com.minhalista.appMinhaLista.dto.item.ItemInputDto;
import com.minhalista.appMinhaLista.dto.item.ItemOutputDto;
import com.minhalista.appMinhaLista.dto.item.QuantidadeItemInputDto;
import com.minhalista.appMinhaLista.model.domain.Item;
import com.minhalista.appMinhaLista.model.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/listas")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/{listaId}/itens")
    public ResponseEntity<ItemOutputDto> criarItem(@PathVariable("listaId") Integer listaId, @RequestBody ItemInputDto inputDto) {
        Item itemCriado = itemService.criar(listaId, inputDto);
        ItemOutputDto outputDto = ItemOutputDto.converter2Dto(itemCriado);
        return new ResponseEntity<ItemOutputDto>(outputDto, HttpStatus.CREATED);
    }

    @PutMapping("/itens")
    public ResponseEntity<ItemOutputDto> atualizarItem(@RequestBody QuantidadeItemInputDto inputDto) {
        Item itemAtualizado = itemService.atualizar(inputDto);
        ItemOutputDto outputDto = ItemOutputDto.converter2Dto(itemAtualizado);
        return ResponseEntity.ok(outputDto);
    }

    @DeleteMapping("/itens/{itemId}")
    public void excluirItem(@PathVariable("itemId") Integer itemId) {
        itemService.excluir(itemId);
    }
}
