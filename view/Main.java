package br.edu.universidade.view;

import java.util.Scanner;
import br.edu.universidade.AlunoController;
import br.edu.universidade.ProfessorController;
import br.edu.universidade.AlunoDao;
import br.edu.universidade.ProfessorDao;


public class Main {

    private AlunoController alunoController;
    private ProfessorController professorController;
    private Scanner scanner;

    public Main() {
        AlunoDao alunoDAO = new AlunoDao();
        this.alunoController = new AlunoController(alunoDAO);

        ProfessorDao professorDao = new ProfessorDao();
        this.professorController = new ProfessorController(professorDao);

        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main view = new Main();
        view.iniciarMenuPrincipal();
    }

    private void iniciarMenuPrincipal() {
        int opcao;

        while (true) {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuAlunos();
                    break;
                case 2:
                    menuProfessores();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

            if (opcao == 0) {
                break;
            }
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n--- Sistema de Gestão Acadêmica ---");
        System.out.println("1. Menu Alunos");
        System.out.println("2. Menu Professores");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void menuAlunos() {
        int opcao;
        while (true) {
            System.out.println("\n--- Menu Alunos ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Consultar Aluno");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    consultarAluno();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (opcao == 0) {
                break;
            }
        }
    }

    private void cadastrarAluno() {
        System.out.print("\nDigite o ID do aluno (somente números): ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o e-mail do aluno: ");
        String email = scanner.nextLine();

        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        alunoController.cadastrarAluno(id, nome, email, cpf);
    }

    private void consultarAluno() {
        System.out.print("\nDigite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        String resultado = alunoController.consultarAlunoPorCpf(cpf);
        System.out.println(resultado);
    }

    private void menuProfessores() {
        int opcao;
        while (true) {
            System.out.println("\n--- Menu Professores ---");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Consultar Professor");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    consultarProfessor();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (opcao == 0) {
                break;
            }
        }
    }

    private void cadastrarProfessor() {
        System.out.print("Digite o ID do professor (somente números): ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o e-mail do professor: ");
        String email = scanner.nextLine();

        professorController.cadastrarProfessor(id, nome, cpf, email);
    }

    private void consultarProfessor() {
        System.out.print("Digite o CPF do professor: "); // Pede o CPF
        String cpf = scanner.nextLine(); // Lê como String

        String resultado = professorController.consultarProfessorPorCpf(cpf);
        System.out.println(resultado);
    }
}