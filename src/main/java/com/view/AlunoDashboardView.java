package com.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlunoDashboardView extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Barra de pesquisa
        TextField searchField = new TextField();
        searchField.setPromptText("Pesquisar por vagas");
        Button searchButton = new Button("Buscar");

        // Lista de vagas (exemplo)
        ObservableList<String> vagas = FXCollections.observableArrayList(
                "Estágio em Desenvolvimento Java",
                "Estágio em Marketing Digital",
                "Estágio em Design Gráfico"
        );
        ListView<String> listView = new ListView<>(vagas);

        // Layout superior com campo de busca
        HBox searchBox = new HBox(10, searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER);

        // Layout principal
        VBox mainContent = new VBox(10, searchBox, listView);
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setPrefWidth(400);

        // Barra de navegação (exemplo)
        Button profileButton = new Button("Meu Perfil");
        Button applicationsButton = new Button("Minhas Aplicações");
        Button logoutButton = new Button("Logout");
        HBox navBar = new HBox(10, profileButton, applicationsButton, logoutButton);
        navBar.setAlignment(Pos.CENTER);

        // Layout geral
        BorderPane root = new BorderPane();
        root.setCenter(mainContent);
        root.setBottom(navBar);

        // Ações dos botões
        profileButton.setOnAction(e -> System.out.println("Navegar para o Perfil"));
        applicationsButton.setOnAction(e -> System.out.println("Navegar para Minhas Aplicações"));
        logoutButton.setOnAction(e -> primaryStage.close());

        // Configuração da cena e do palco
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Painel do Aluno");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
