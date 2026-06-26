package br.com.nilson.service;

import br.com.nilson.model.OrdemServico;
import br.com.nilson.model.Veiculo;
import br.com.nilson.repository.OrdemServicoRepository;
import br.com.nilson.repository.VeiculoRepository;

public class OrdemServicoService {

    private OrdemServicoRepository ordemRepository = new OrdemServicoRepository();
    private VeiculoRepository veiculoRepository = new VeiculoRepository();

    public void abrirOrdemServico(int idVeiculo, String descricao, double valor, String status) {

        Veiculo veiculo = veiculoRepository.buscarPorId(idVeiculo);

        if (veiculo == null) {
            throw new RuntimeException("Veículo não encontrado.");
        }

        if (valor < 0) {
            throw new RuntimeException("Valor não pode ser negativo.");
        }

        OrdemServico ordem = new OrdemServico(idVeiculo, descricao, valor, status);

        ordemRepository.salvar(ordem);
    }

    public void consultarHistorico(int idVeiculo) {
        ordemRepository.listarHistoricoPorVeiculo(idVeiculo);
    }
}