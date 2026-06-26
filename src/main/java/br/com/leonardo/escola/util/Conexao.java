package br.com.leonardo.escola.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/escola";

    private static final String USER = "postgres";
    private static final String PASSWORD = "1618";

    public static Connection conectar() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL não encontrado", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}