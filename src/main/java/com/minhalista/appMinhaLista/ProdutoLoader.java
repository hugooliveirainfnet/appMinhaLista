package com.minhalista.appMinhaLista;

import com.minhalista.appMinhaLista.model.domain.Produto;
import com.minhalista.appMinhaLista.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(4)
@Component
public class ProdutoLoader implements ApplicationRunner {
    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final int PRODUCT_NAME = 0;
        final int PRICE = 1;

        FileReader produtoFile = new FileReader("files/produtos.txt");
        BufferedReader produtoBuffer = new BufferedReader(produtoFile);

        String linha = produtoBuffer.readLine();
        String[] atributos = {};

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {
                Produto produto = new Produto(atributos[PRODUCT_NAME], Double.valueOf(atributos[PRICE]));

                produtoService.criar(produto);

            }
            linha = produtoBuffer.readLine();
            numeroLinha++;
        }

        for(Produto produto : produtoService.listar()){
            System.out.println("[PRODUTO] " + produto);
        }
        System.out.print("\n");

        produtoBuffer.close();
    }

}
