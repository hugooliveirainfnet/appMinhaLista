package com.minhalista.appMinhaLista;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Participante;
import com.minhalista.appMinhaLista.model.domain.Produto;
import com.minhalista.appMinhaLista.model.service.GrupoService;
import com.minhalista.appMinhaLista.model.service.ParticipanteService;
import com.minhalista.appMinhaLista.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

@Order(3)
@Component
public class ProdutoLoader implements ApplicationRunner {
    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader produtoFile = new FileReader("files/produtos.txt");
        BufferedReader produtoBuffer = new BufferedReader(produtoFile);

        String linha = produtoBuffer.readLine();
        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {
                Produto produto = new Produto(Integer.valueOf(atributos[0]), atributos[1], atributos[2], atributos[3],
                        Double.valueOf(atributos[4]), LocalDateTime.parse(atributos[5]));

                produtoService.incluir(produto);

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
