package com.minhalista.appMinhaLista;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Item;
import com.minhalista.appMinhaLista.model.domain.Participante;
import com.minhalista.appMinhaLista.model.domain.Produto;
import com.minhalista.appMinhaLista.model.service.GrupoService;
import com.minhalista.appMinhaLista.model.service.ItemService;
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

@Order(4)
@Component
public class ItemLoader implements ApplicationRunner {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader itemFile = new FileReader("files/itens.txt");
        BufferedReader itemBuffer = new BufferedReader(itemFile);

        FileReader produtoFile = new FileReader("files/produtos.txt");
        BufferedReader produtoBuffer = new BufferedReader(produtoFile);
        produtos(produtoBuffer);

        String linha = itemBuffer.readLine();
        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {

                Produto produto = produtoService.buscar(Integer.valueOf(atributos[2]));
                Item item = new Item(Integer.valueOf(atributos[0]), Double.valueOf(atributos[1]), produto);
                itemService.incluir(item);

            }
            linha = itemBuffer.readLine();
            numeroLinha++;
        }

        for(Item item : itemService.listar()){
            System.out.println("[ITEM] " + item);
        }
        System.out.print("\n");

        produtoBuffer.close();
        itemBuffer.close();
    }

    private void produtos (BufferedReader bufferedReader) throws IOException {

        String linha = bufferedReader.readLine();
        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {
                Produto produto = new Produto(Integer.valueOf(atributos[0]), atributos[1], atributos[2], atributos[3],
                        Double.valueOf(atributos[4]), LocalDateTime.parse(atributos[5]));

                produtoService.incluir(produto);
            }
            linha = bufferedReader.readLine();
            numeroLinha++;
        }
    }
}
