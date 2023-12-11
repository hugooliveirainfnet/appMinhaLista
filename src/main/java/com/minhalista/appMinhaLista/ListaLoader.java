package com.minhalista.appMinhaLista;

import com.minhalista.appMinhaLista.model.domain.*;
import com.minhalista.appMinhaLista.model.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class ListaLoader implements ApplicationRunner {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private ListaService listaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final int LIST_NAME = 0;
        final int GROUP = 1;

        FileReader listaFile = new FileReader("files/listas.txt");
        BufferedReader listaBruffer = new BufferedReader(listaFile);

        String linha = listaBruffer.readLine();
        String[] atributos = {};

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {
                Grupo grupo = grupoService.buscar(Integer.valueOf(atributos[GROUP])).get();
                Lista lista = new Lista(atributos[LIST_NAME], grupo);
                listaService.incluir(lista);

            }
            linha = listaBruffer.readLine();
            numeroLinha++;
        }

        for(Lista lista : listaService.listar()) {
            System.out.println("[LISTA] " + lista);
        }
        System.out.print("\n");
        listaBruffer.close();

    }
}
