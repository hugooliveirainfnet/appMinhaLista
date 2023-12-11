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

@Order(2)
@Component
public class GrupoLoader implements ApplicationRunner {

    @Autowired
    private GrupoService grupoService;
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final int GROUP_NAME = 0;
        final int GROUP_MEMBERS = 1;

        FileReader grupoFile = new FileReader("files/grupos.txt");
        BufferedReader grupoBruffer = new BufferedReader(grupoFile);

        String linha = grupoBruffer.readLine();
        String[] atributos = {};

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {

                String[] integrantes = atributos[GROUP_MEMBERS].split(",");
                Grupo grupo = null;
                Usuario usuario;
                for (String integrante :integrantes) {
                    usuario = usuarioService.buscar(Integer.valueOf(integrante)).get() ;
                    if(grupo==null) {
                        grupo = new Grupo(atributos[GROUP_NAME], usuario);
                        grupo = grupoService.incluir(grupo);
                    }
                    else{
                        grupo.setUsuario(usuario);
                    }
                    usuario.setGrupo(grupo);
                    usuarioService.incluir(usuario);
                }
                grupo = grupoService.incluir(grupo);
            }
            linha = grupoBruffer.readLine();
            numeroLinha++;
        }

        for(Grupo grupo : grupoService.listar()){
            System.out.println("[GRUPO] " + grupo);
        }
        System.out.print("\n");

        grupoBruffer.close();

    }

}
