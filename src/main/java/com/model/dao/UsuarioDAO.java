package src.main.java.com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.main.java.com.model.Usuario;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public boolean inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, senha, tipo) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTipo());
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se a inserção for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false se houver falha
        }
    }
    

    // READ (Buscar usuário por ID)
    public Usuario buscarUsuarioPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Crie o Usuario com o construtor adequado
                Usuario usuario = new Usuario(
                    rs.getLong("id"),          // Passa o ID
                    rs.getString("nome"),      // Passa o nome
                    rs.getString("senha"),     // Passa a senha
                    rs.getString("tipo")       // Passa o tipo
                );
                return usuario; // Retorna o usuario encontrado
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }
    

    // UPDATE
    public void atualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, senha = ?, tipo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTipo());
            stmt.setLong(4, usuario.getId());
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletarUsuario(Long id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    // READ (Listar todos os usuários)
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Criação do Usuario com os parâmetros do construtor
                Usuario usuario = new Usuario(
                    rs.getLong("id"),          // Passa o ID
                    rs.getString("nome"),      // Passa o nome
                    rs.getString("senha"),     // Passa a senha
                    rs.getString("tipo")       // Passa o tipo
                );
                usuarios.add(usuario); // Adiciona o usuário à lista
            }
        }
        return usuarios; // Retorna a lista de usuários
    }
    
}
