package br.edu.universidade;

public class ProfessorDao {
    public void salvar(Professor professor) {
        System.out.println("Professor " + professor.getNome() + " salvo no banco de dados.");
    }
}
