package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.application;

public class AplicacaoDAO {
    private Connection connection;

    public AplicacaoDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void inserirAplicacao(Aplicacao aplicacao) throws SQLException {
        String sql = "INSERT INTO aplicacoes (aluno_id, vaga_id, data_aplicacao) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, aplicacao.getAlunoId());
            stmt.setLong(2, aplicacao.getVagaId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(aplicacao.getDataAplicacao())); // Converter LocalDateTime para Timestamp
            stmt.executeUpdate();
        }
    }

    // READ (Buscar aplicação por ID)
    public Aplicacao buscarAplicacaoPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM aplicacoes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Aplicacao aplicacao = new Aplicacao(
                    rs.getLong("id"),
                    rs.getLong("aluno_id"),
                    rs.getLong("vaga_id"),
                    rs.getTimestamp("data_aplicacao").toLocalDateTime()
                );
                return aplicacao;
            }
        }
        return null;
    }

    // UPDATE
    public void atualizarAplicacao(Aplicacao aplicacao) throws SQLException {
        String sql = "UPDATE aplicacoes SET aluno_id = ?, vaga_id = ?, data_aplicacao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, aplicacao.getAlunoId());
            stmt.setLong(2, aplicacao.getVagaId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(aplicacao.getDataAplicacao())); // Converter LocalDateTime para Timestamp
            stmt.setLong(4, aplicacao.getId());
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletarAplicacao(Long id) throws SQLException {
        String sql = "DELETE FROM aplicacoes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    // READ (Listar todas as aplicações)
    public List<Aplicacao> listarAplicacoes() throws SQLException {
        List<Aplicacao> aplicacoes = new ArrayList<>();
        String sql = "SELECT * FROM aplicacoes";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aplicacao aplicacao = new Aplicacao(
                    rs.getLong("id"),
                    rs.getLong("aluno_id"),
                    rs.getLong("vaga_id"),
                    rs.getTimestamp("data_aplicacao").toLocalDateTime()
                );
                aplicacoes.add(aplicacao);
            }
        }
        return aplicacoes;
    }
}
