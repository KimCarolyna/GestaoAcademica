package br.edu.universidade;
import java.util.Scanner;

public class Main {

    private AlunoController alunoController;
    private ProfessorController professorController;
    private Scanner scanner;

    public Main(){
        Alunodao alunoDAO = new Alunodao();
        this.alunoController = new AlunoController(alunoDAO);

        ProfessorDAO professorDAO = new ProfessorDAO();
        this.professorController = new ProfessorController(professorDAO);

        this.scanner = new Scanner(System.in);
    }

    public static void main (String[]args) {
        Main view = new Main();
        view.iniciarMenuPrincipal();
    }

    private void iniciarMenuPrincipal(){
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
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
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
        System.out.print("Digite o ID do aluno (somente números): ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o e-mail do aluno: ");
        String email = scanner.nextLine();

        alunoController.cadastrarAluno(id, nome, email);
    }

    private void menuProfessores() {
        int opcao;
        while (true) {
            System.out.println("\n--- Menu Professores ---");
            System.out.println("1. Cadastrar Professor");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
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
}