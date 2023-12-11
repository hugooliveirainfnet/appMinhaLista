package com.minhalista.appMinhaLista;

import com.minhalista.appMinhaLista.model.domain.Usuario;

import com.minhalista.appMinhaLista.model.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final int USER_NAME = 0;
        final int USER_EMAIL = 1;
        final int USER_TELEFONE = 2;

        FileReader usuarioFile = new FileReader("files/usuarios.txt");
        BufferedReader usuarioBuffer = new BufferedReader(usuarioFile);

        String linha = usuarioBuffer.readLine();
        String[] atributos = {};

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {
                Usuario usuario = new Usuario(atributos[USER_NAME], atributos[USER_EMAIL], atributos[USER_TELEFONE]);
                usuarioService.incluir(usuario);
            }
            linha = usuarioBuffer.readLine();
            numeroLinha++;
        }

        for(Usuario usuario : usuarioService.listar()){
            System.out.println("[USUARIO] " + usuario);
        }

        System.out.print("\n");
        usuarioBuffer.close();
    }

}
