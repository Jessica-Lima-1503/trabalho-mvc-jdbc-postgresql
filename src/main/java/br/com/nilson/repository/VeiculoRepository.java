package br.com.nilson.repository;

import br.com.nilson.model.Veiculo;
import br.com.nilson.util.Conexao;

import java.sql.*;

public class VeiculoRepository {

    public int salvar(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, modelo, ano, id_cliente) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());
            stmt.setInt(4, veiculo.getIdCliente());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            throw new RuntimeException("Erro ao obter ID do veículo.");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar veículo: " + e.getMessage());
        }
    }

    public Veiculo buscarPorId(int id) {
        String sql = "SELECT * FROM veiculo WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getInt("id_cliente")
                );
            }

            return null;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar veículo: " + e.getMessage());
        }
    }
}