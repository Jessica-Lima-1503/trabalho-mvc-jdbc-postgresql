package br.com.clinicavet.service;

import br.com.clinicavet.model.Animal;
import br.com.clinicavet.repository.AnimalRepository;

public class AnimalService {

    private AnimalRepository repository = new AnimalRepository();

    public void salvar(Animal animal) {
        repository.salvar(animal);
    }

    public void listar() {
        repository.listar();
    }
}