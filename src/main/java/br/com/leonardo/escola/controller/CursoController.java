package br.com.leonardo.escola.controller;

import br.com.leonardo.escola.model.Curso;
import br.com.leonardo.escola.repository.CursoRepository;

import java.util.List;

public class CursoController {

    private CursoRepository repository = new CursoRepository();

    public void cadastrar(Curso curso) {
        repository.salvar(curso);
    }

    public List<Curso> listar() {
        return repository.listar();
    }
}