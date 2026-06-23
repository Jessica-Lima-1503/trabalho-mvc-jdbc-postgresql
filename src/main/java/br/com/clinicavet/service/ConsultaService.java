package br.com.clinicavet.service;

import br.com.clinicavet.model.Consulta;
import br.com.clinicavet.repository.ConsultaRepository;

public class ConsultaService {

    private ConsultaRepository repository = new ConsultaRepository();

    public void salvar(Consulta consulta) {

        if (consulta.getValor() < 0) {
            System.out.println("Valor da consulta não pode ser negativo!");
            return;
        }

        repository.salvar(consulta);
    }

    public void listar() {
        repository.listar();
    }
}