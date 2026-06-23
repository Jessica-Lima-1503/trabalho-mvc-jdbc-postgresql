package br.com.clinicavet.repository;

import br.com.clinicavet.connection.Conexao;
import br.com.clinicavet.model.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorRepository {

    public void salvar(Tutor tutor) {

        String sql = "INSERT INTO tutor (nome, endereco, telefone) VALUES (?, ?, ?)";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, tutor.getNome());
            stmt.setString(2, tutor.getEndereco());
            stmt.setString(3, tutor.getTelefone());

            stmt.executeUpdate();

            System.out.println("Tutor salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar tutor: " + e.getMessage());
        }
    }

    public void listar() {

        String sql = "SELECT * FROM tutor";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("nome") + " - " +
                                rs.getString("endereco") + " - " +
                                rs.getString("telefone")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }
}