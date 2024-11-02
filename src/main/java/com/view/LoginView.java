package com.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginView extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Layout da tela
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        // Componentes da tela
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Senha:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Registrar");

        // Adicionando os componentes no grid
        grid.add(emailLabel, 0, 0);
        grid.add(emailField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(registerButton, 1, 3);

        // Ação do botão de login (exemplo de navegação para tela principal)
        loginButton.setOnAction(e -> {
            // Aqui você faria a validação do login
            System.out.println("Tentativa de login");
            // Se login válido, navega para a próxima tela (não implementada aqui)
        });

        // Ação do botão de registro
        registerButton.setOnAction(e -> {
            // Redireciona para a tela de registro
            System.out.println("Redirecionando para registro");
        });

        // Configuração da cena e do palco
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
