package src.main.java.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.main.java.model.Vaga;

public class VagaDAO {
    private Connection connection;

    public VagaDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void inserirVaga(Vaga vaga) throws SQLException {
        String sql = "INSERT INTO vagas (titulo, descricao, area_de_atuacao, requisitos, modalidade, flag_vaga_publicada, empresa_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vaga.getTitulo());
            stmt.setString(2, vaga.getDescricao());
            stmt.setString(3, vaga.getAreaDeAtuacao());
            stmt.setString(4, vaga.getRequisitos());
            stmt.setString(5, vaga.getModalidade());
            stmt.setBoolean(6, vaga.isFlagVagaPublicada()); // Ajustado para boolean
            stmt.setLong(7, vaga.getEmpresaId());
            stmt.executeUpdate();
        }
    }

    // READ (Buscar vaga por ID)
    public Vaga buscarVagaPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM vagas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Vaga vaga = new Vaga(
                    rs.getLong("id"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    rs.getString("area_de_atuacao"),
                    rs.getString("requisitos"),
                    rs.getString("modalidade"),
                    rs.getBoolean("flag_vaga_publicada"), // Ajustado para boolean
                    rs.getLong("empresa_id")
                );
                return vaga;
            }
        }
        return null;
    }

    // UPDATE
    public void atualizarVaga(Vaga vaga) throws SQLException {
        String sql = "UPDATE vagas SET titulo = ?, descricao = ?, area_de_atuacao = ?, requisitos = ?, modalidade = ?, flag_vaga_publicada = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vaga.getTitulo());
            stmt.setString(2, vaga.getDescricao());
            stmt.setString(3, vaga.getAreaDeAtuacao());
            stmt.setString(4, vaga.getRequisitos());
            stmt.setString(5, vaga.getModalidade());
            stmt.setBoolean(6, vaga.isFlagVagaPublicada()); // Ajustado para boolean
            stmt.setLong(7, vaga.getId());
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletarVaga(Long id) throws SQLException {
        String sql = "DELETE FROM vagas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    // READ (Listar todas as vagas)
    public List<Vaga> listarVagas() throws SQLException {
        List<Vaga> vagas = new ArrayList<>();
        String sql = "SELECT * FROM vagas";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vaga vaga = new Vaga(
                    rs.getLong("id"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    rs.getString("area_de_atuacao"),
                    rs.getString("requisitos"),
                    rs.getString("modalidade"),
                    rs.getBoolean("flag_vaga_publicada"), // Ajustado para boolean
                    rs.getLong("empresa_id")
                );
                vagas.add(vaga);
            }
        }
        return vagas;
    }
}
