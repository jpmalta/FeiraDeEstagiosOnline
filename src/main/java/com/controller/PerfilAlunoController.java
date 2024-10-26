package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.model.Aluno;
import com.dao.AlunoDAO;

public class PerfilAlunoController {
    @FXML
    private TextField nomeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField cursoField;

    private Aluno aluno;

    public void initialize() {
        // Carregar informações do aluno
        AlunoDAO alunoDAO = new AlunoDAO();
        aluno = alunoDAO.buscarAlunoPorId(1L); // exemplo de ID
        nomeField.setText(aluno.getNome());
        emailField.setText(aluno.getEmail());
        cursoField.setText(aluno.getCurso());
    }

    @FXML
    private void handleAtualizarButtonAction() {
        aluno.setNome(nomeField.getText());
        aluno.setEmail(emailField.getText());
        aluno.setCurso(cursoField.getText());

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.atualizarAluno(aluno);
        
        System.out.println("Perfil atualizado com sucesso!");
    }
}
