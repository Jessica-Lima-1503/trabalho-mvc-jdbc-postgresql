package br.com.nilson.controller;

import br.com.nilson.service.ClienteService;

public class ClienteController {

    private ClienteService service = new ClienteService();

    public int cadastrarCliente(String nome, String telefone) {

        int idCliente = service.cadastrarCliente(nome, telefone);

        System.out.println("Cliente cadastrado com sucesso. ID: " + idCliente);

        return idCliente;
    }
}
