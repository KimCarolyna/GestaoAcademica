package br.edu.universidade;

public class AlunoController {
    private Alunodao alunoDAO;

    public AlunoController(Alunodao alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public void cadastrarAluno(int id, String nome, String email) {
        Aluno aluno = new Aluno(id, nome, email);
        alunoDAO.salvar(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }
}