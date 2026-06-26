package br.com.nilson.repository;

import br.com.nilson.model.OrdemServico;
import br.com.nilson.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrdemServicoRepository {

    public void salvar(OrdemServico ordem) {
        String sql = "INSERT INTO ordem_servico (id_veiculo, descricao, valor, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ordem.getIdVeiculo());
            stmt.setString(2, ordem.getDescricao());
            stmt.setDouble(3, ordem.getValor());
            stmt.setString(4, ordem.getStatus());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar ordem de serviço: " + e.getMessage());
        }
    }

    public void listarHistoricoPorVeiculo(int idVeiculo) {
        String sql = "SELECT * FROM ordem_servico WHERE id_veiculo = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVeiculo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID da ordem: " + rs.getInt("id"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("Valor: R$ " + rs.getDouble("valor"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("---------------------------");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar histórico: " + e.getMessage());
        }
    }
}