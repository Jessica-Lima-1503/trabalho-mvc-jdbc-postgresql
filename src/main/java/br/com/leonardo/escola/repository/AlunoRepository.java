package br.com.leonardo.escola.repository;

import br.com.leonardo.escola.model.Aluno;
import br.com.leonardo.escola.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    public void salvar(Aluno aluno) {

        String sql = "INSERT INTO aluno(nome,email,telefone) VALUES(?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getTelefone());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                aluno.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Aluno> listar() {

        List<Aluno> lista = new ArrayList<>();

        String sql = "SELECT * FROM aluno ORDER BY id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setEmail(rs.getString("email"));
                a.setTelefone(rs.getString("telefone"));

                lista.add(a);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
}