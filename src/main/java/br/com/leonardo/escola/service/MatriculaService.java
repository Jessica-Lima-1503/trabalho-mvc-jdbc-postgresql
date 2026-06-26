package br.com.leonardo.escola.service;

import br.com.leonardo.escola.model.Matricula;
import br.com.leonardo.escola.repository.MatriculaRepository;

public class MatriculaService {

    private MatriculaRepository repository = new MatriculaRepository();

    public void matricular(Matricula matricula) {

        if (matricula.getValor() < 0) {
            throw new RuntimeException("Valor da matrícula não pode ser negativo.");
        }

        if (!repository.alunoExiste(matricula.getIdAluno())) {
            throw new RuntimeException("Aluno não encontrado.");
        }

        if (!repository.cursoExiste(matricula.getIdCurso())) {
            throw new RuntimeException("Curso não encontrado.");
        }

        if (repository.matriculaDuplicada(
                matricula.getIdAluno(),
                matricula.getIdCurso()
        )) {
            throw new RuntimeException("Aluno já está matriculado neste curso.");
        }

        if (!repository.cursoTemVagas(matricula.getIdCurso())) {
            throw new RuntimeException("Curso sem vagas disponíveis.");
        }

        repository.salvar(matricula);
        repository.baixarVaga(matricula.getIdCurso());
    }
}
