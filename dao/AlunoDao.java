package br.edu.universidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            System.err.println("Erro ao salvar aluno no BD: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                Conexao.fechar(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
    
    public Aluno buscarPorMatricula(int matricula) {
        
        String sql = "SELECT a.id_aluno, a.nome, a.email, a.cpf " +
                     "FROM aluno a " +
                     "JOIN matricula m ON a.id_aluno = m.id_aluno " +
                     "WHERE m.id_matricula = ?";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        Aluno aluno = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, matricula);
            
            rs = stmt.executeQuery(); // Executa a consulta SELECT

            if (rs.next()) {
                
                int id = rs.getInt("id_aluno");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                
               
                aluno = new Aluno(id, nome, email, cpf);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar aluno por matrícula: " + e.getMessage());
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                Conexao.fechar(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return aluno;
    }
}