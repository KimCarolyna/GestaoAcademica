package br.edu.universidade;

public class Alunodao {
    public void salvar(Aluno aluno){
        System.out.println("Aluno "  + aluno.getNome() + " salvo no banco de dados.");
    }

    public Aluno buscarPorId(int id){
        System.out.println("Buscando aluno com ID " + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }
}