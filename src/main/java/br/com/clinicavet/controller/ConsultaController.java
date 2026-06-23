package br.com.clinicavet.controller;

import br.com.clinicavet.model.Consulta;
import br.com.clinicavet.service.ConsultaService;

public class ConsultaController {

    private ConsultaService service = new ConsultaService();

    public void salvar(Consulta consulta) {
        service.salvar(consulta);
    }

    public void listar() {
        service.listar();
    }
}