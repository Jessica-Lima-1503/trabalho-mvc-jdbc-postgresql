package br.com.leonardo.escola.controller;

import br.com.leonardo.escola.model.Aluno;
import br.com.leonardo.escola.repository.AlunoRepository;

import java.util.List;

public class AlunoController {

    private AlunoRepository repository = new AlunoRepository();

    public void cadastrar(Aluno aluno) {
        repository.salvar(aluno);
    }

    public List<Aluno> listar() {
        return repository.listar();
    }
}