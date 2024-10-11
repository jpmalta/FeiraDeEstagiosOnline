/* Desenvolvimento do Projeto Integrador IV da PUC Campinas, grupo 09, projeto: Feira de estágios online */
-- João Pedro Costa Malta RA: 23002743

CREATE DATABASE OnlineIntershipsDB;

-- Comum para alunos e empresas
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL, -- Username
    -- email VARCHAR(320) NOT NULL, -- A princípio não usaremos validação via e-mail para evitar a complexidade.
    senha VARCHAR(255) NOT NULL, -- Guardar a senha como hash (por isso o VARCHAR(255))
    tipo ENUM('aluno', 'empresa') NOT NULL
);

-- Detalhes adicionais sobre os alunos
CREATE TABLE alunos (
    id BIGINT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    perfil_academico VARCHAR(255),
    descricao TEXT,
    curriculo LONGBLOB, -- Usando LONGBLOB para grandes arquivos binários
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Detalhes adicionais sobre as empresas
CREATE TABLE empresas (
    id BIGINT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    cidade VARCHAR(60),
    descricao TEXT,
    dados_empresa TEXT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Para as vagas de estágio
CREATE TABLE vagas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT, -- Usando TEXT para grandes descrições
    area_de_atuacao VARCHAR(255),
    requisitos TEXT,
    modalidade ENUM('remoto', 'presencial'),
    flag_vaga_publicada ENUM('S', 'N') DEFAULT 'N',
    empresa_id BIGINT, -- Corrigido para BIGINT, para ser compatível com a chave estrangeira
    FOREIGN KEY (empresa_id) REFERENCES empresas(id)
);

-- Para registrar as aplicações dos alunos às vagas
CREATE TABLE aplicacoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    aluno_id BIGINT,
    vaga_id BIGINT,
    data_aplicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (aluno_id) REFERENCES alunos(id),
    FOREIGN KEY (vaga_id) REFERENCES vagas(id)
);

-- Exemplos de uso
-- Para saber em quais vagas um aluno específico aplicou:
SELECT 
    vagas.titulo, vagas.descricao, aplicacoes.data_aplicacao
FROM 
    aplicacoes
JOIN 
    vagas 
    ON aplicacoes.vaga_id = vagas.id
WHERE 
    aplicacoes.aluno_id = 1;

-- Para que uma empresa veja todas as aplicações feitas às suas vagas:
SELECT 
    alunos.id AS aluno_id, usuarios.nome AS aluno_nome, aplicacoes.data_aplicacao, vagas.titulo
FROM 
    aplicacoes
JOIN vagas 
    ON aplicacoes.vaga_id = vagas.id
JOIN empresas 
    ON vagas.empresa_id = empresas.id
JOIN alunos 
    ON aplicacoes.aluno_id = alunos.id
JOIN usuarios 
    ON alunos.usuario_id = usuarios.id
WHERE 
    empresas.id = 1;
