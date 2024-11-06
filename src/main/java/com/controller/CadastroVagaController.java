package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import com.model.Vaga;
import com.model.dao.VagaDAO;

public class CadastroVagaController {
    @FXML
    private TextField tituloField;

    @FXML
    private TextArea descricaoArea;

    @FXML
    private TextField requisitosField;

    @FXML
    private TextField tipoField;

    @FXML
    private void handleSalvarButtonAction() {
        Vaga vaga = new Vaga();
        vaga.setTitulo(tituloField.getText());
        vaga.setDescricao(descricaoArea.getText());
        vaga.setRequisitos(requisitosField.getText());
        vaga.setTipo(tipoField.getText());

        VagaDAO vagaDAO = new VagaDAO();
        vagaDAO.inserirVaga(vaga);
        
        System.out.println("Vaga cadastrada com sucesso!");
    }
}
