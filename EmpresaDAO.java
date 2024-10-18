import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
    private Connection connection;

    public EmpresaDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void inserirEmpresa(Empresa empresa) throws SQLException {
        String sql = "INSERT INTO empresas (usuario_id, cidade, descricao, dados_empresa) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, empresa.getId()); // Usando getId() da superclasse Usuario
            stmt.setString(2, empresa.getCidade());
            stmt.setString(3, empresa.getDescricao());
            stmt.setString(4, empresa.getDadosEmpresa());
            stmt.executeUpdate();
        }
    }

    // READ (Buscar empresa por ID)
    public Empresa buscarEmpresaPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM empresas WHERE usuario_id = ?"; // Ajuste na condição de busca
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Empresa empresa = new Empresa(
                    rs.getLong("usuario_id"), // ID do usuário
                    rs.getString("nome"), // Supondo que o nome está na tabela "usuarios"
                    rs.getString("senha"), // Supondo que a senha está na tabela "usuarios"
                    rs.getString("cidade"),
                    rs.getString("descricao"),
                    rs.getString("dados_empresa")
                );
                empresa.setId(rs.getLong("usuario_id")); // Ajuste para o ID da empresa
                return empresa;
            }
        }
        return null;
    }

    // UPDATE
    public void atualizarEmpresa(Empresa empresa) throws SQLException {
        String sql = "UPDATE empresas SET cidade = ?, descricao = ?, dados_empresa = ? WHERE usuario_id = ?"; // Usando usuario_id como chave
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empresa.getCidade());
            stmt.setString(2, empresa.getDescricao());
            stmt.setString(3, empresa.getDadosEmpresa());
            stmt.setLong(4, empresa.getId()); // Ajuste para usar o ID correto
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletarEmpresa(Long id) throws SQLException {
        String sql = "DELETE FROM empresas WHERE usuario_id = ?"; // Usando usuario_id como chave
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    // READ (Listar todas as empresas)
    public List<Empresa> listarEmpresas() throws SQLException {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM empresas";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa(
                    rs.getLong("usuario_id"), // ID do usuário
                    rs.getString("nome"), // Supondo que o nome está na tabela "usuarios"
                    rs.getString("senha"), // Supondo que a senha está na tabela "usuarios"
                    rs.getString("cidade"),
                    rs.getString("descricao"),
                    rs.getString("dados_empresa")
                );
                empresa.setId(rs.getLong("usuario_id")); // Ajuste para o ID da empresa
                empresas.add(empresa);
            }
        }
        return empresas;
    }
}
