package com.model;

public class Vaga {
    private Long id;
    private String titulo;
    private String descricao;
    private String areaDeAtuacao;
    private String requisitos;
    private String modalidade; // "remoto" ou "presencial"
    private boolean flagVagaPublicada; // S ou N
    private Long empresaId;

    // Construtor
    public Vaga(Long id, String titulo, String descricao, String areaDeAtuacao, String requisitos, String modalidade, boolean flagVagaPublicada, Long empresaId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.areaDeAtuacao = areaDeAtuacao;
        this.requisitos = requisitos;
        this.modalidade = modalidade;
        this.flagVagaPublicada = flagVagaPublicada;
        this.empresaId = empresaId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public boolean isFlagVagaPublicada() {
        return flagVagaPublicada;
    }

    public void setFlagVagaPublicada(boolean flagVagaPublicada) {
        this.flagVagaPublicada = flagVagaPublicada;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }
}
