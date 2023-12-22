package com.minhalista.appMinhaLista.model.services;

import com.minhalista.appMinhaLista.clients.IEnderecoClient;
import com.minhalista.appMinhaLista.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoClient enderecoClient;

    public Endereco buscarCep(String cep) {
        return enderecoClient.buscarCep(cep);

    }
}
