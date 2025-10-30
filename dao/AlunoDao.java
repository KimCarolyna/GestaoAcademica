package br.edu.universidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDao {

    public void salvar(Aluno aluno) {

        String sql = "INSERT INTO aluno (id_aluno, nome, cpf, email) VALUES (?, ?, ?, ?)";
        String sqlMatricula = "INSERT INTO matricula (id_aluno, id_disciplina, data_matricula) VALUES (?, ?, CURDATE())";

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

            stmtMatricula = conn.prepareStatement(sqlMatricula);
            stmtMatricula.setInt(1, aluno.getId());
            stmtMatricula.setInt(2, aluno.getIdDisciplina());
            stmtMatricula.executeUpdate();

           System.out.println("Aluno " + aluno.getNome() + " e matrícula salvos com sucesso.");
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

    public Aluno buscarPorCpf(String cpf) {

        String sql = "SELECT a.id_aluno, a.nome, a.email, a.cpf, d.nome AS nome_disciplina " +
                "FROM aluno a " +
                "LEFT JOIN matricula m ON a.id_aluno = m.id_aluno " +
                "LEFT JOIN disciplina d ON m.id_disciplina = d.id_disciplina " +
                "WHERE a.cpf = ?";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aluno aluno = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);

            rs = stmt.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id_aluno");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String alunoCpf = rs.getString("cpf");
                String nomeDisciplina = rs.getString("nome_disciplina");

                aluno = new Aluno(id, nome, email, alunoCpf);
                aluno.setDisciplinaMatriculada(nomeDisciplina);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar aluno por CPF: " + e.getMessage());
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
