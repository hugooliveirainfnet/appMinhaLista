package com.minhalista.appMinhaLista.controller;

import com.minhalista.appMinhaLista.dto.produto.ProdutoDto;
import com.minhalista.appMinhaLista.model.domain.Produto;
import com.minhalista.appMinhaLista.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoDto> criarProduto(@RequestBody ProdutoDto inputDto) {
        Produto produtoInput = ProdutoDto.converter2Model(inputDto);
        Produto produtoIncluido = produtoService.criar(produtoInput);
        ProdutoDto outputDto = ProdutoDto.converter2Dto(produtoIncluido);
        return new ResponseEntity<ProdutoDto>(outputDto, HttpStatus.CREATED);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDto>> listarProdutos() {
        List<Produto> produtos = (List<Produto>) produtoService.listar();
        List<ProdutoDto> outputDtos = ProdutoDto.converter2ListDto(produtos);
        return ResponseEntity.ok(outputDtos);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoDto> obterProduto(@PathVariable("id") Integer id) {
        Produto produto = produtoService.buscar(id);
        ProdutoDto outputDto = ProdutoDto.converter2Dto(produto);
        return ResponseEntity.ok(outputDto);
    }

    @PutMapping("/produtos")
    public ResponseEntity<ProdutoDto> atualizarProduto(@RequestBody ProdutoDto inputDto) {
        Produto novoProduto = ProdutoDto.converter2Model(inputDto);
        Produto produtoAtualizado = produtoService.atualizar(novoProduto);
        ProdutoDto outputDto = ProdutoDto.converter2Dto(produtoAtualizado);
        return ResponseEntity.ok(outputDto);
    }

    @DeleteMapping("/produtos/{id}")
    public void excluirProduto(@PathVariable("id") Integer id) {
        produtoService.excluir(id);
    }
}
