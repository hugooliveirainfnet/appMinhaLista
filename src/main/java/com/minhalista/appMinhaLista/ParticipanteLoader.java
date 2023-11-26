package com.minhalista.appMinhaLista;

import com.minhalista.appMinhaLista.model.domain.Grupo;
import com.minhalista.appMinhaLista.model.domain.Participante;
import com.minhalista.appMinhaLista.model.service.GrupoService;
import com.minhalista.appMinhaLista.model.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Order(1)
@Component
public class ParticipanteLoader implements ApplicationRunner {
    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private GrupoService grupoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader participanteFile = new FileReader("files/participantes.txt");
        BufferedReader participanteBuffer = new BufferedReader(participanteFile);

        FileReader grupoFile = new FileReader("files/grupos.txt");
        BufferedReader grupoBuffer = new BufferedReader(grupoFile);
        grupos(grupoBuffer);

        String linha = participanteBuffer.readLine();
        String[] atributos = null;

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {
                Participante participante = new Participante(Integer.valueOf(atributos[0]), atributos[1], atributos[2], atributos[3]);
                if(atributos[5] != "") {
                    Grupo grupo = grupoService.buscar(Integer.valueOf(atributos[5]));
                    participante.setGrupo(grupo);
                }
                participante.setDataCriacao(LocalDateTime.parse(atributos[6]));

                participanteService.incluir(participante);


            }
            linha = participanteBuffer.readLine();
            numeroLinha++;
        }

        for(Participante participante : participanteService.listar()){
            System.out.println("[PARTICIPANTE] " + participante);
        }

        System.out.print("\n");

        grupoBuffer.close();
        participanteBuffer.close();

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
}
