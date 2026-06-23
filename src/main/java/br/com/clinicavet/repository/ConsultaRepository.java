package br.com.clinicavet.repository;

import br.com.clinicavet.connection.Conexao;
import br.com.clinicavet.model.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaRepository {

    public void salvar(Consulta consulta) {

        if (consulta.getValor() < 0) {
            System.out.println("Valor da consulta não pode ser negativo!");
            return;
        }

        String sql =
                "INSERT INTO consulta (data, motivo, animal_id, valor) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setDate(1, java.sql.Date.valueOf(consulta.getData()));
            stmt.setString(2, consulta.getMotivo());
            stmt.setInt(3, consulta.getAnimalId());
            stmt.setDouble(4, consulta.getValor());

            stmt.executeUpdate();

            System.out.println("Consulta salva com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar consulta: " + e.getMessage());
        }
    }

    public void listar() {

        String sql = "SELECT * FROM consulta";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getDate("data") + " - " +
                                rs.getString("motivo") + " - " +
                                rs.getInt("animal_id") + " - R$ " +
                                rs.getDouble("valor")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar consultas: " + e.getMessage());
        }
    }
}