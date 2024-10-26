package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.dao.UsuarioDAO;
import com.model.Usuario;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario user = usuarioDAO.autenticar(username, password);

        if (user != null) {
            System.out.println("Login realizado com sucesso!");
            // Redirecionar para a tela principal do aluno ou empresa
        } else {
            System.out.println("Credenciais inválidas.");
        }
    }
}
