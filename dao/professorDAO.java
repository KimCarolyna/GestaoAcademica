package br.edu.universidade;

public class ProfessorDAO {
    public void salvar(Professor professor) {
        System.out.println("Professor " + professor.getNome() + " salvo no banco de dados.");
    }
}