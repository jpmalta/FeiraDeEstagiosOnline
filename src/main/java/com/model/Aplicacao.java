package com.model;

import java.time.LocalDateTime;

public class Aplicacao {
    private Long id;
    private Long alunoId;
    private Long vagaId;
    private LocalDateTime dataAplicacao;

    // Construtor
    public Aplicacao(Long id, Long alunoId, Long vagaId, LocalDateTime dataAplicacao) {
        this.id = id;
        this.alunoId = alunoId;
        this.vagaId = vagaId;
        this.dataAplicacao = dataAplicacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getVagaId() {
        return vagaId;
    }

    public void setVagaId(Long vagaId) {
        this.vagaId = vagaId;
    }

    public LocalDateTime getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDateTime dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
