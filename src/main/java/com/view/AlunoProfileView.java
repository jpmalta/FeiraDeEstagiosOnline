package src.main.java.com.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoProfileView extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Layout da tela
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        // Componentes do formulário de perfil
        Label nameLabel = new Label("Nome:");
        TextField nameField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label academicProfileLabel = new Label("Perfil Acadêmico:");
        TextField academicProfileField = new TextField();
        Button saveButton = new Button("Salvar");

        // Adicionando componentes no grid
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(academicProfileLabel, 0, 2);
        grid.add(academicProfileField, 1, 2);
        grid.add(saveButton, 1, 3);

        // Ação do botão salvar
        saveButton.setOnAction(e -> {
            System.out.println("Perfil salvo!");
        });

        // Configuração da cena e do palco
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setTitle("Perfil do Aluno");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
