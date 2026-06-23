package br.com.clinicavet.repository;

import br.com.clinicavet.connection.Conexao;
import br.com.clinicavet.model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalRepository {

    public void salvar(Animal animal) {

        String sql = "INSERT INTO animal (nome, especie, raca, tutor_id) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getTutorId());

            stmt.executeUpdate();

            System.out.println("Animal salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar animal: " + e.getMessage());
        }
    }

    public void listar() {

        String sql = "SELECT * FROM animal";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("nome") + " - " +
                                rs.getString("especie") + " - " +
                                rs.getString("raca")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar animais: " + e.getMessage());
        }
    }
}