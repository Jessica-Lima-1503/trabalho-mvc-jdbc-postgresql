package br.com.nilson.model;

public class OrdemServico {

    private int idVeiculo;
    private String descricao;
    private double valor;
    private String status;

    public OrdemServico(int idVeiculo, String descricao, double valor, String status) {
        this.idVeiculo = idVeiculo;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }
}
