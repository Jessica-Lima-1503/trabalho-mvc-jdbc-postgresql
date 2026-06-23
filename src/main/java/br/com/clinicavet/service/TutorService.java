package br.com.clinicavet.service;

import br.com.clinicavet.model.Tutor;
import br.com.clinicavet.repository.TutorRepository;

public class TutorService {

    private TutorRepository repository = new TutorRepository();

    public void salvar(Tutor tutor) {
        repository.salvar(tutor);
    }

    public void listar() {
        repository.listar();
    }
}