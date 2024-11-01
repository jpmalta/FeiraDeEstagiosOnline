package src.main.java.com.application;

import java.sql.Connection;
import com.model.dao.usuarioDAO;
import com.util.ConexaoMySQL;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando o teste da aplicação...");

        // 1. Testar a conexão com o banco de dados
        Connection conexao = ConexaoMySQL.conectar();
        if (conexao != null) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
            return;  // Se não houver conexão, encerra o programa
        }

        // 2. Criar uma instância de UsuarioDAO com a conexão estabelecida
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

        // 3. Criar um novo usuário usando o construtor correto (com parâmetros)
        Usuario novoUsuario = new Usuario(null, "João Pedro", "12345678", "aluno");

        // 4. Inserir o novo usuário no banco de dados
            boolean sucesso = usuarioDAO.inserirUsuario(novoUsuario);
        if (sucesso) {
            System.out.println("Usuário inserido com sucesso!");
        } else {
            System.out.println("Erro ao inserir o usuário.");
        }
    }
}
