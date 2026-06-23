package br.com.clinicavet.controller;

import br.com.clinicavet.model.Tutor;
import br.com.clinicavet.service.TutorService;

public class TutorController {

    private TutorService service = new TutorService();

    public void salvar(Tutor tutor) {
        service.salvar(tutor);
    }

    public void listar() {
        service.listar();
    }
}