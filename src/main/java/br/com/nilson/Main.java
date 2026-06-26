package br.com.nilson;

import br.com.nilson.controller.ClienteController;
import br.com.nilson.controller.VeiculoController;
import br.com.nilson.controller.OrdemServicoController;

public class Main {

    public static void main(String[] args) {

        ClienteController clienteController = new ClienteController();
        VeiculoController veiculoController = new VeiculoController();
        OrdemServicoController ordemController = new OrdemServicoController();

        try {
            System.out.println("=== SISTEMA DE OFICINA MECÂNICA ===");

            System.out.println("\n1 - Cadastrando cliente");

            int idCliente = clienteController.cadastrarCliente(
                    "Carlos Oliveira",
                    "4499999-1234"
            );

            System.out.println("\n2 - Cadastrando veículo");

            int idVeiculo = veiculoController.cadastrarVeiculo(
                    "ABC1234",
                    "Gol",
                    2015,
                    idCliente
            );

            System.out.println("\n3 - Abrindo ordem de serviço");

            ordemController.abrirOrdemServico(
                    idVeiculo,
                    "Troca de óleo e revisão geral",
                    250.00,
                    "ABERTA"
            );

            System.out.println("\n4 - Consultando histórico do veículo");

            ordemController.consultarHistorico(idVeiculo);

            System.out.println("\nFluxo finalizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}