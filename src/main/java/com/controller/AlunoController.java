package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import com.model.Vaga;
import com.dao.VagaDAO;

import java.util.List;

public class AlunoController {
    @FXML
    private ListView<Vaga> vagaListView;

    @FXML
    private Button aplicarButton;

    public void initialize() {
        VagaDAO vagaDAO = new VagaDAO();
        List<Vaga> vagas = vagaDAO.listarVagas();
        vagaListView.getItems().addAll(vagas);
    }

    @FXML
    private void handleAplicarButtonAction() {
        Vaga selectedVaga = vagaListView.getSelectionModel().getSelectedItem();
        if (selectedVaga != null) {
            System.out.println("Aplicando para a vaga: " + selectedVaga.getTitulo());
            // Lógica de aplicação para a vaga
        } else {
            System.out.println("Selecione uma vaga para aplicar.");
        }
    }
}
