package br.com.nilson.service;

import br.com.nilson.model.Cliente;
import br.com.nilson.model.Veiculo;
import br.com.nilson.repository.ClienteRepository;
import br.com.nilson.repository.VeiculoRepository;

public class VeiculoService {

    private VeiculoRepository veiculoRepository = new VeiculoRepository();
    private ClienteRepository clienteRepository = new ClienteRepository();

    public int cadastrarVeiculo(String placa, String modelo, int ano, int idCliente) {

        Cliente cliente = clienteRepository.buscarPorId(idCliente);

        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado.");
        }

        Veiculo veiculo = new Veiculo(placa, modelo, ano, idCliente);

        return veiculoRepository.salvar(veiculo);
    }
}