package br.edu.universidade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/gestaoacademica";
    private static final String USUARIO = "root";
    private static final String SENHA = "sua_senha_aqui";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: Verifique se o MySQL está rodando e se as credenciais estão corretas.");
            throw new RuntimeException("Falha na conexão com o DB: " + e.getMessage(), e);
        }
    }

    public static void fechar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}