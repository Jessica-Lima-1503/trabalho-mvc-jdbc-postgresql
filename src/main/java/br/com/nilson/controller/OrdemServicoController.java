package br.com.nilson.controller;

import br.com.nilson.service.OrdemServicoService;

public class OrdemServicoController {

    private OrdemServicoService service = new OrdemServicoService();

    public void abrirOrdemServico(int idVeiculo, String descricao, double valor, String status) {

        service.abrirOrdemServico(idVeiculo, descricao, valor, status);

        System.out.println("Ordem de serviço aberta com sucesso.");
    }

    public void consultarHistorico(int idVeiculo) {
        service.consultarHistorico(idVeiculo);
    }
}