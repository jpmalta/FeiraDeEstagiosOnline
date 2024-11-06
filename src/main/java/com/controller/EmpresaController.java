package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import com.model.Vaga;
import com.model.dao.VagaDAO;

import java.util.List;

public class EmpresaController {
    @FXML
    private ListView<Vaga> vagasPublicadasListView;

    @FXML
    private Button novaVagaButton;

    public void initialize() {
        VagaDAO vagaDAO = new VagaDAO();
        List<Vaga> vagas = vagaDAO.listarVagasPorEmpresa(1L); // exemplo de ID da empresa
        vagasPublicadasListView.getItems().addAll(vagas);
    }

    @FXML
    private void handleNovaVagaButtonAction() {
        System.out.println("Abrir formulário para publicação de nova vaga.");
        // Lógica para abrir uma nova tela/formulário de publicação de vaga
    }
}
