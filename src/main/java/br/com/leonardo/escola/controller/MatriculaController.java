package br.com.leonardo.escola.controller;

import br.com.leonardo.escola.model.Matricula;
import br.com.leonardo.escola.service.MatriculaService;

public class MatriculaController {

    private MatriculaService service = new MatriculaService();

    public void matricular(Matricula matricula) {
        service.matricular(matricula);
    }
}
