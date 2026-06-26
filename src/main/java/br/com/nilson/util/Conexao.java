package br.com.nilson.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/oficina";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}