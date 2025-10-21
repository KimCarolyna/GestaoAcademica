package br.edu.universidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDao {

    public void salvar(Aluno aluno){
        String sql = "INSERT INTO aluno (id_aluno, nome, cpf, email) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getEmail());

            stmt.executeUpdate();

            System.out.println("Aluno "  + aluno.getNome() + " salvo no banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar aluno no DB: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                Conexao.fechar(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
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