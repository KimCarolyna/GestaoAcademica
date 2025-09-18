import java.util.Scanner;

public class Main {

  private AlunoController alunocontroller;
  private Scanner scanner;

  public main(){
    this.alunoController = new AlunoController();
    this.scanner = new Scanner(System.in);
  }

  public static void main (String[]args) {
    msin view = new main();
    view.iniciarMenuPrincipal();
  }

  
}
