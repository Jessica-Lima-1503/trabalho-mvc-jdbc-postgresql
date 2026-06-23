package br.com.clinicavet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {


    private static final String URL =
            "jdbc:postgresql://localhost:5432/clinica-veterinaria";

    private static final String USUARIO = "postgres";
    private static final String SENHA = "207402";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
