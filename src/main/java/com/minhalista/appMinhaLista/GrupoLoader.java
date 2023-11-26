package com.minhalista.appMinhaLista;

import com.minhalista.appMinhaLista.model.domain.*;
import com.minhalista.appMinhaLista.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Order(2)
@Component
public class GrupoLoader implements ApplicationRunner {

    @Autowired
    private GrupoService grupoService;
    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private ListaService listaService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ItemService itemService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader grupoFile = new FileReader("files/grupos.txt");
        BufferedReader grupoBruffer = new BufferedReader(grupoFile);
//        grupos(grupoBruffer);

        FileReader produtoFile = new FileReader("files/produtos.txt");
        BufferedReader produtoBuffer = new BufferedReader(produtoFile);
        produtos(produtoBuffer);

        FileReader itemFile = new FileReader("files/itens.txt");
        BufferedReader itemBuffer = new BufferedReader(itemFile);
        itens(itemBuffer);

        FileReader listaFile = new FileReader("files/listas.txt");
        BufferedReader listaBruffer = new BufferedReader(listaFile);


        FileReader participanteFile = new FileReader("files/participantes.txt");
        BufferedReader participanteBuffer = new BufferedReader(participanteFile);
        participantes(participanteBuffer);

        String linha = grupoBruffer.readLine();
        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {
                Integer grupoId = Integer.valueOf(atributos[0]);
                Grupo grupo = new Grupo(grupoId, atributos[1]);
                grupoService.incluir(grupo);
                listas(listaBruffer);
                grupoService.buscar(grupoId).setListas(listaService.listar().stream().toList());

                String[] p = atributos[3].split(",");
                for (String id : p) {
                    Participante pessoa = participanteService.buscar(Integer.valueOf( id ) );
                    grupoService.buscar(grupoId).setParticipante( pessoa );
                }

                String[] adcaoParticipante = atributos[4].split(",");
                for (String map : adcaoParticipante) {
                    String[] idData = map.split("\\|");
                    Participante pessoa = participanteService.buscar(Integer.valueOf( idData[0] ) );
                    grupoService.buscar(grupoId).setDataAdicaoParticipante(pessoa, LocalDateTime.parse(idData[1]));
                }
            }
            linha = grupoBruffer.readLine();
            numeroLinha++;
        }

        for(Grupo grupo : grupoService.listar()){
            System.out.println("[GRUPO] " + grupo);
        }
        System.out.print("\n");

        grupoBruffer.close();
        listaBruffer.close();
        itemBuffer.close();
        produtoBuffer.close();
        participanteBuffer.close();
    }

    private void participantes (BufferedReader bufferedReader) throws IOException {
        String linha = bufferedReader.readLine();

        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            if(numeroLinha !=0) {
                atributos = linha.split(";");
                Participante participante = new Participante(Integer.valueOf(atributos[0]), atributos[1], atributos[2], atributos[3]);
                participanteService.incluir(participante);
            }
            linha = bufferedReader.readLine();
            numeroLinha++;
        }
    }
    private void grupos (BufferedReader bufferedReader) throws IOException {
        String linha = bufferedReader.readLine();

        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            if(numeroLinha !=0) {
                atributos = linha.split(";");
                Grupo grupo = new Grupo(Integer.valueOf(atributos[0]), atributos[1] );
                grupoService.incluir(grupo);
            }
            linha = bufferedReader.readLine();
            numeroLinha++;
        }
    }
    private void itens (BufferedReader bufferedReader) throws IOException {
        String linha = bufferedReader.readLine();

        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            if(numeroLinha !=0) {
                atributos = linha.split(";");
                Produto produto = produtoService.buscar(Integer.valueOf(atributos[2]));
                Item item = new Item(Integer.valueOf(atributos[0]), Double.valueOf(atributos[1]), produto);
                itemService.incluir(item);
            }
            linha = bufferedReader.readLine();
            numeroLinha++;
        }
    }

    private void listas (BufferedReader bufferedReader) throws IOException {
        String linha = bufferedReader.readLine();

        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {
                Grupo grupo = grupoService.buscar(Integer.valueOf(atributos[3]));
                Collection<Item> itens = itemService.listar();
                Lista lista = new Lista(Integer.valueOf(atributos[0]), atributos[1], grupo);
                lista.setItens(itens.stream().toList());

                listaService.incluir(lista);
            }
            linha = bufferedReader.readLine();
            numeroLinha++;
        }
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
