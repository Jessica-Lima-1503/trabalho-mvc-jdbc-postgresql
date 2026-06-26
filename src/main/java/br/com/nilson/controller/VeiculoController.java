package br.com.nilson.controller;

import br.com.nilson.service.VeiculoService;

public class VeiculoController {

    private VeiculoService service = new VeiculoService();

    public int cadastrarVeiculo(String placa, String modelo, int ano, int idCliente) {

        int idVeiculo = service.cadastrarVeiculo(placa, modelo, ano, idCliente);

        System.out.println("Veículo cadastrado com sucesso. ID: " + idVeiculo);

        return idVeiculo;
    }
}