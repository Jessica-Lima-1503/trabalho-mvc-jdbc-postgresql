package br.com.leonardo.escola.repository;

import br.com.leonardo.escola.model.Curso;
import br.com.leonardo.escola.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {

    public void salvar(Curso curso) {

        String sql = "INSERT INTO curso (nome,descricao,carga_horaria,vagas_totais,vagas_disponiveis) VALUES (?,?,?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getDescricao());
            ps.setInt(3, curso.getCargaHoraria());
            ps.setInt(4, curso.getVagasTotais());
            ps.setInt(5, curso.getVagasDisponiveis());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                curso.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 🔥 ESSE MÉTODO PRECISA EXISTIR
    public List<Curso> listar() {

        List<Curso> lista = new ArrayList<>();

        String sql = "SELECT * FROM curso ORDER BY id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDescricao(rs.getString("descricao"));
                c.setCargaHoraria(rs.getInt("carga_horaria"));
                c.setVagasTotais(rs.getInt("vagas_totais"));
                c.setVagasDisponiveis(rs.getInt("vagas_disponiveis"));

                lista.add(c);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
}