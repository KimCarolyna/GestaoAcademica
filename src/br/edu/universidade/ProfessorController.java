package br.edu.universidade;

public class ProfessorController {
    private ProfessorDAO professorDAO;

    public ProfessorController(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    public void cadastrarProfessor(int id, String nome, String cpf, String email) {
        Professor professor = new Professor(id, nome, cpf, email);
        professorDAO.salvar(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }
}