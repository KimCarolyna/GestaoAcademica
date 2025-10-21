package br.edu.universidade;

public class AlunoController {
    private AlunoDao alunoDao;

    public AlunoController(AlunoDao alunoDao) {
        this.alunoDao = alunoDao;
    }

    public void cadastrarAluno(int id, String nome, String email, String cpf) {
        Aluno aluno = new Aluno(id, nome, email, cpf);
        alunoDao.salvar(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public String consultarAlunoPorMatricula(int matricula) {
    Aluno aluno = alunoDao.buscarPorMatricula(matricula);
    if (aluno != null) {
        return aluno.toString();
    } else {
        return "Aluno não encontrado.";
        }
    }
}
