package src.main.java.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.main.java.model.Aluno;

public class AlunoDAO {
    private Connection connection;

    public AlunoDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void inserirAluno(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (usuario_id, perfil_academico, descricao, curriculo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, aluno.getId()); // Usando getId() da superclasse Usuario
            stmt.setString(2, aluno.getPerfilAcademico());
            stmt.setString(3, aluno.getDescricao());
            stmt.setBytes(4, aluno.getCurriculo());
            stmt.executeUpdate();
        }
    }

    // READ (Buscar aluno por ID)
    public Aluno buscarAlunoPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM alunos WHERE usuario_id = ?"; // Ajuste na condição de busca
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getLong("usuario_id"), // ID do usuário
                    rs.getString("nome"), // Supondo que o nome está na tabela "usuarios"
                    rs.getString("senha"), // Supondo que a senha está na tabela "usuarios"
                    rs.getString("perfil_academico"),
                    rs.getString("descricao"),
                    rs.getBytes("curriculo")
                );
                aluno.setId(rs.getLong("usuario_id")); // Ajuste para o ID da empresa
                return aluno;
            }
        }
        return null;
    }

    // UPDATE
    public void atualizarAluno(Aluno aluno) throws SQLException {
        String sql = "UPDATE alunos SET perfil_academico = ?, descricao = ?, curriculo = ? WHERE usuario_id = ?"; // Usando usuario_id como chave
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getPerfilAcademico());
            stmt.setString(2, aluno.getDescricao());
            stmt.setBytes(3, aluno.getCurriculo());
            stmt.setLong(4, aluno.getId()); // Ajuste para usar o ID correto
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletarAluno(Long id) throws SQLException {
        String sql = "DELETE FROM alunos WHERE usuario_id = ?"; // Usando usuario_id como chave
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    // READ (Listar todos os alunos)
    public List<Aluno> listarAlunos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getLong("usuario_id"), // ID do usuário
                    rs.getString("nome"), // Supondo que o nome está na tabela "usuarios"
                    rs.getString("senha"), // Supondo que a senha está na tabela "usuarios"
                    rs.getString("perfil_academico"),
                    rs.getString("descricao"),
                    rs.getBytes("curriculo")
                );
                aluno.setId(rs.getLong("usuario_id")); // Ajuste para o ID da empresa
                alunos.add(aluno);
            }
        }
        return alunos;
    }
}
