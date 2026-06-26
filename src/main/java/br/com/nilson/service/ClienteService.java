package br.com.nilson.service;

import br.com.nilson.model.Cliente;
import br.com.nilson.repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository repository = new ClienteRepository();

    public int cadastrarCliente(String nome, String telefone) {

        if (nome == null || nome.isBlank()) {
            throw new RuntimeException("Nome do cliente é obrigatório.");
        }

        if (telefone == null || telefone.isBlank()) {
            throw new RuntimeException("Telefone do cliente é obrigatório.");
        }

        Cliente cliente = new Cliente(nome, telefone);

        return repository.salvar(cliente);
    }
}