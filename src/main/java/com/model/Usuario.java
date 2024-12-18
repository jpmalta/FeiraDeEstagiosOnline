package com.model;

public class Usuario {
    private Long id;
    private String nome;
    private String senha;
    private String tipo; // "aluno" ou "empresa"
    
    // Construtor
    public Usuario(Long id, String nome, String senha, String tipo) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
