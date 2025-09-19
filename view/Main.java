import java.util.Scanner;

public class Main {

  private AlunoController alunocontroller;
  private Scanner scanner;

  public Main(){
    this.alunoController = new AlunoController();
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
          System.out.println("Opções de professores");
          break;
        
        case 0:
            System.out.println("Saindo do sistema...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
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
                    System.out.println("Voltando...");
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
        System.out.print("Digite o ID do aluno: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o e-mail do aluno: ");
        String email = scanner.nextLine();

        alunoController.cadastrarAluno(id, nome, email);
    }
}
