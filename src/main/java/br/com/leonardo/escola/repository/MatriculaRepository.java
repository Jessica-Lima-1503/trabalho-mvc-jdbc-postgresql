package br.com.leonardo.escola.repository;

import br.com.leonardo.escola.model.Matricula;
import br.com.leonardo.escola.util.Conexao;

import java.sql.*;

public class MatriculaRepository {

    public void salvar(Matricula m) {

        String sql = "INSERT INTO matricula (id_aluno,id_curso,data_matricula,valor) VALUES (?,?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getIdAluno());
            ps.setInt(2, m.getIdCurso());
            ps.setDate(3, Date.valueOf(m.getDataMatricula()));
            ps.setDouble(4, m.getValor());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean alunoExiste(int idAluno) {
        String sql = "SELECT 1 FROM aluno WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idAluno);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean cursoExiste(int idCurso) {
        String sql = "SELECT 1 FROM curso WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCurso);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean matriculaDuplicada(int idAluno, int idCurso) {
        String sql = "SELECT 1 FROM matricula WHERE id_aluno=? AND id_curso=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idAluno);
            ps.setInt(2, idCurso);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean cursoTemVagas(int idCurso) {
        String sql = "SELECT vagas_disponiveis FROM curso WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCurso);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("vagas_disponiveis") > 0;
            }

            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void baixarVaga(int idCurso) {
        String sql = "UPDATE curso SET vagas_disponiveis = vagas_disponiveis - 1 WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCurso);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
