package br.edu.universidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDao {
    public void salvar(Professor professor) {
        String sql = "INSERT INTO professor (id_professor, nome, cpf, email) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, professor.getId());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getCpf());
            stmt.setString(4, professor.getEmail());

            stmt.executeUpdate();

            System.out.println("Professor " + professor.getNome() + " salvo no banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar professor no BD: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                Conexao.fechar(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public Professor buscarPorCpf(String cpf) {

        String sql = "SELECT p.id_professor, p.nome, p.cpf, p.formacao, p.area_atuacao, p.email, p.telefone, p.remuneracao, " +
                "GROUP_CONCAT(d.nome SEPARATOR ', ') AS disciplinas_lecionadas " +
                "FROM professor p " +
                "LEFT JOIN disciplina d ON p.id_professor = d.id_professor " +
                "WHERE p.cpf = ? " +
                "GROUP BY p.id_professor, p.nome, p.cpf, p.formacao, p.area_atuacao, p.email, p.telefone, p.remuneracao";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Professor professor = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);

            rs = stmt.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id_professor");
                String nome = rs.getString("nome");
                String professorCpf = rs.getString("cpf");
                String email = rs.getString("email");

                professor = new Professor(id, nome, professorCpf, email);
                professor.setFormacao(rs.getString("formacao"));
                professor.setAreaAtuacao(rs.getString("area_atuacao"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setRemuneracao(rs.getDouble("remuneracao"));

                professor.setDisciplinasLecionadas(rs.getString("disciplinas_lecionadas"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar professor por CPF: " + e.getMessage());
        } finally {

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                Conexao.fechar(conn);
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return professor;
    }
}
