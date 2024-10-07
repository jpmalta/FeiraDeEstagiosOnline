/* Desenvolvimento do Projeto Integrador IV da PUC Campinas, grupo 09, projeto: Feira de estágios online */
-- João Pedro Costa Malta RA: 23002743

create database OnlineIntershipsDB;

-- comum para alunos e empresas
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL,
    senha VARCHAR(8) NOT NULL, -- Fazer uma validação de que a senha deve ser de até 8 caracteres apenas
    tipo ENUM('aluno', 'empresa') NOT NULL
);

-- Detalhes adicionais sobre os alunos
CREATE TABLE alunos (
    id INT PRIMARY KEY,
    perfil_academico VARCHAR(255),
    curriculo TEXT,
    FOREIGN KEY (id) REFERENCES usuarios(id)
);

-- Detalhes adicionais sobre as empresas
CREATE TABLE empresas (
    id INT PRIMARY KEY,
    dados_empresa TEXT,
    FOREIGN KEY (id) REFERENCES usuarios(id)
);

-- Para as vagas de estágio
CREATE TABLE vagas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    descricao TEXT,
    requisitos TEXT,
    tipo ENUM('remoto', 'presencial'),
    empresa_id INT,
    FOREIGN KEY (empresa_id) REFERENCES empresas(id)
);
