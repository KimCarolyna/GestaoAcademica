package br.edu.universidade;

public class ProfessorDAO {
    public void salvar(Professor professor) {
        // Simulação de persistência no banco de dados
        System.out.println("Professor " + professor.getNome() + " salvo no banco de dados. (Simulação de persistência)");
    }

    // Outros métodos DAO (buscar, atualizar, etc.) seriam implementados aqui.
}
