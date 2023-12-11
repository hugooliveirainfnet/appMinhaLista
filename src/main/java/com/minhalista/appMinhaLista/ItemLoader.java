package com.minhalista.appMinhaLista;

import com.minhalista.appMinhaLista.model.domain.Item;
import com.minhalista.appMinhaLista.model.domain.Lista;
import com.minhalista.appMinhaLista.model.domain.Produto;
import com.minhalista.appMinhaLista.model.domain.Usuario;
import com.minhalista.appMinhaLista.model.services.ItemService;
import com.minhalista.appMinhaLista.model.services.ListaService;
import com.minhalista.appMinhaLista.model.services.ProdutoService;
import com.minhalista.appMinhaLista.model.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@Order(5)
@Component
public class ItemLoader implements ApplicationRunner {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ListaService listaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final int AMOUNT = 0;
        final int AMOUNT_PAY= 1;
        final int PRODUCT = 2;
        final int LIST = 3;

        FileReader itemFile = new FileReader("files/itens.txt");
        BufferedReader itemBuffer = new BufferedReader(itemFile);

        String linha = itemBuffer.readLine();
        String[] atributos = {};

        int numeroLinha = 0;
        while (linha != null) {
            atributos = linha.split(";");
            if(numeroLinha !=0) {

                Produto produto = produtoService.buscar(Integer.valueOf(atributos[PRODUCT])).get();
                Lista lista = listaService.buscar(Integer.valueOf(atributos[LIST])).get();

                Item item = new Item(Integer.valueOf(atributos[AMOUNT]), Double.valueOf(atributos[AMOUNT_PAY]), produto, lista);
                itemService.incluir(item);

            }
            linha = itemBuffer.readLine();
            numeroLinha++;
        }

        for(Item item : itemService.listar()){
            System.out.println("[ITEM] " + item);
        }

        Optional<Usuario> usuario = usuarioService.buscar(1);
        Double valor = usuario.get().getGrupos().get(0).getListas().get(0).calcularValorTotalLista();

        System.out.println("Valor total "+valor);

        System.out.print("\n");
        itemBuffer.close();
    }

}
