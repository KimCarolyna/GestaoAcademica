package br.edu.universidade;

public class AlunoController {
    private AlunoDao alunoDao;

    public AlunoController(AlunoDao alunoDao) {
        this.alunoDao = alunoDao;
    }

    public void cadastrarAluno(int id, String nome, String email) {
        Aluno aluno = new Aluno(id, nome, email);
        alunoDao.salvar(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }
}
