public class Alunodao {
  public void salvar(Aluno aluno){
    System.out.println("Aluno "  + aluno.getNome() + " salvo no banco de dados.");
  }

  public Aluno buscarPorId(int id){
    System.out.println("Buscando aluno com ID " + id);
  try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
    }
    return null;
  }
}
