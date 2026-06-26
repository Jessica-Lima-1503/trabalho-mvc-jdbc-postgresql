package br.com.nilson.repository;

import br.com.nilson.model.Cliente;
import br.com.nilson.util.Conexao;

import java.sql.*;

public class ClienteRepository {

    public int salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            throw new RuntimeException("Erro ao obter ID do cliente.");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone")
                );
            }

            return null;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente: " + e.getMessage());
        }
    }
}