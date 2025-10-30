package br.edu.universidade;

public class AlunoController {
    private AlunoDao alunoDao;

    public AlunoController(AlunoDao alunoDao) {
        this.alunoDao = alunoDao;
    }

    public void cadastrarAluno(int id, String nome, String email, String cpf, int idDisciplina) {
    Aluno aluno = new Aluno(id, nome, email, cpf);
    aluno.setIdDisciplina(idDisciplina);
    alunoDao.salvar(aluno);
}
    public String consultarAlunoPorCpf(String cpf) {
        Aluno aluno = alunoDao.buscarPorCpf(cpf);
        if (aluno != null) {
            return aluno.toString();
        } else {
            return "Aluno não encontrado.";
        }
    }
}
