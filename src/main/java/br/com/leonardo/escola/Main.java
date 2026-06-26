package br.com.leonardo.escola;

import br.com.leonardo.escola.controller.AlunoController;
import br.com.leonardo.escola.controller.CursoController;
import br.com.leonardo.escola.controller.MatriculaController;
import br.com.leonardo.escola.model.Aluno;
import br.com.leonardo.escola.model.Curso;
import br.com.leonardo.escola.model.Matricula;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AlunoController alunoController = new AlunoController();
        CursoController cursoController = new CursoController();
        MatriculaController matriculaController = new MatriculaController();

        while (true) {

            System.out.println("\n===== SISTEMA ESCOLA =====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Fazer Matrícula");
            System.out.println("4 - Listar Alunos");
            System.out.println("5 - Listar Cursos");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    alunoController.cadastrar(new Aluno(nome, email, telefone));

                    System.out.println("Aluno cadastrado com sucesso!");
                }

                case 2 -> {
                    System.out.print("Nome do curso: ");
                    String nome = sc.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Carga horária: ");
                    int carga = sc.nextInt();

                    System.out.print("Vagas totais: ");
                    int vagas = sc.nextInt();
                    sc.nextLine();

                    cursoController.cadastrar(new Curso(nome, descricao, carga, vagas, vagas));

                    System.out.println("Curso cadastrado com sucesso!");
                }

                case 3 -> {
                    System.out.println("\n--- ALUNOS CADASTRADOS ---");
                    List<Aluno> alunos = alunoController.listar();
                    for (Aluno a : alunos) {
                        System.out.println(a.getId() + " - " + a.getNome());
                    }

                    System.out.println("\n--- CURSOS CADASTRADOS ---");
                    List<Curso> cursos = cursoController.listar();
                    for (Curso c : cursos) {
                        System.out.println(c.getId() + " - " + c.getNome());
                    }

                    System.out.print("\nID Aluno: ");
                    int idAluno = sc.nextInt();

                    System.out.print("ID Curso: ");
                    int idCurso = sc.nextInt();

                    System.out.print("Valor matrícula: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    matriculaController.matricular(
                            new Matricula(idAluno, idCurso, LocalDate.now(), valor)
                    );

                    System.out.println("Matrícula realizada com sucesso!");
                }

                case 4 -> {
                    System.out.println("\n--- LISTA DE ALUNOS ---");
                    for (Aluno a : alunoController.listar()) {
                        System.out.println(
                                a.getId() + " - " +
                                        a.getNome() + " - " +
                                        a.getEmail() + " - " +
                                        a.getTelefone()
                        );
                    }
                }

                case 5 -> {
                    System.out.println("\n--- LISTA DE CURSOS ---");
                    for (Curso c : cursoController.listar()) {
                        System.out.println(
                                c.getId() + " - " +
                                        c.getNome() + " | vagas: " +
                                        c.getVagasDisponiveis()
                        );
                    }
                }

                case 0 -> {
                    System.out.println("Encerrando sistema...");
                    return;
                }

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}