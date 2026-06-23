package br.com.clinicavet;

import br.com.clinicavet.controller.AnimalController;
import br.com.clinicavet.controller.ConsultaController;
import br.com.clinicavet.controller.TutorController;
import br.com.clinicavet.model.Animal;
import br.com.clinicavet.model.Consulta;
import br.com.clinicavet.model.Tutor;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TutorController tutorController = new TutorController();
        AnimalController animalController = new AnimalController();
        ConsultaController consultaController = new ConsultaController();

        int opcao;

        do {

            System.out.println("\n=================================");
            System.out.println("     CLÍNICA VETERINÁRIA");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar Tutor");
            System.out.println("2 - Cadastrar Animal");
            System.out.println("3 - Registrar Consulta");
            System.out.println("4 - Listar Tutores");
            System.out.println("5 - Listar Animais");
            System.out.println("6 - Listar Consultas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    Tutor tutor = new Tutor();

                    System.out.print("Nome do tutor: ");
                    tutor.setNome(scanner.nextLine());

                    System.out.print("Endereço: ");
                    tutor.setEndereco(scanner.nextLine());

                    System.out.print("Telefone: ");
                    tutor.setTelefone(scanner.nextLine());

                    tutorController.salvar(tutor);

                    break;

                case 2:

                    Animal animal = new Animal();

                    System.out.println("\n=== TUTORES CADASTRADOS ===");
                    tutorController.listar();

                    System.out.print("\nNome do animal: ");
                    animal.setNome(scanner.nextLine());

                    System.out.print("Espécie: ");
                    animal.setEspecie(scanner.nextLine());

                    System.out.print("Raça: ");
                    animal.setRaca(scanner.nextLine());

                    System.out.print("ID do tutor: ");
                    animal.setTutorId(scanner.nextInt());
                    scanner.nextLine();

                    animalController.salvar(animal);

                    break;

                case 3:

                    Consulta consulta = new Consulta();

                    System.out.println("\n=== ANIMAIS CADASTRADOS ===");
                    animalController.listar();

                    System.out.print("\nID do animal: ");
                    consulta.setAnimalId(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Motivo da consulta: ");
                    consulta.setMotivo(scanner.nextLine());

                    System.out.print("Valor da consulta: ");
                    consulta.setValor(scanner.nextDouble());
                    scanner.nextLine();

                    consulta.setData(LocalDate.now());

                    consultaController.salvar(consulta);

                    break;

                case 4:

                    System.out.println("\n=== TUTORES CADASTRADOS ===");
                    tutorController.listar();

                    break;

                case 5:

                    System.out.println("\n=== ANIMAIS CADASTRADOS ===");
                    animalController.listar();

                    break;

                case 6:

                    System.out.println("\n=== CONSULTAS REGISTRADAS ===");
                    consultaController.listar();

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}