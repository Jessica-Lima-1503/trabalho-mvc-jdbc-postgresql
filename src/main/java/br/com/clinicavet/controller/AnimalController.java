package br.com.clinicavet.controller;

import br.com.clinicavet.model.Animal;
import br.com.clinicavet.service.AnimalService;

public class AnimalController {

    private AnimalService service = new AnimalService();

    public void salvar(Animal animal) {
        service.salvar(animal);
    }

    public void listar() {
        service.listar();
    }
}