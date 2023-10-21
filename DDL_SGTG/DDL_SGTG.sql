CREATE SCHEMA sgtg;

USE sgtg;

CREATE TABLE atividade (
id_atividade BIGINT auto_increment PRIMARY KEY,
atividade_nome varchar(64),
atividade_data_entrega datetime NOT NULL,
descricao varchar(128) NOT NULL
);

CREATE TABLE aluno (
aluno_email_fatec varchar(128) PRIMARY KEY,
nome varchar(128)
);

CREATE TABLE professor (
professor_email_fatec varchar(128) PRIMARY KEY,
nome varchar(128)
);

CREATE TABLE materia_tg1 (
id_tg1 BIGINT auto_increment PRIMARY KEY,
tipo varchar(32) NOT NULL,
problema varchar(128),
empresa varchar(64),
disciplina varchar(64),
aluno_email_fatec varchar(128),
professor_email_fatec varchar(128),
id_atividade BIGINT,

CONSTRAINT fk_atividade_tg1 FOREIGN KEY (id_atividade)
	REFERENCES atividade (id_atividade)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_aluno_tg1 FOREIGN KEY (aluno_email_fatec)
	REFERENCES aluno(aluno_email_fatec)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_professor_tg1 FOREIGN KEY (professor_email_fatec)
	REFERENCES professor(professor_email_fatec)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE materia_tg2 (
id_tg2 BIGINT auto_increment PRIMARY KEY,
tipo varchar(32) NOT NULL,
problema varchar(128),
empresa varchar(64),
disciplina varchar(64),
aluno_email_fatec varchar(128),
professor_email_fatec varchar(128),
id_atividade BIGINT,

CONSTRAINT fk_atividade_tg2 FOREIGN KEY (id_atividade)
	REFERENCES atividade (id_atividade)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_aluno_tg2 FOREIGN KEY (aluno_email_fatec)
	REFERENCES aluno(aluno_email_fatec)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_professor_tg2 FOREIGN KEY (professor_email_fatec)
	REFERENCES professor(professor_email_fatec)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE semestre (
nome_semestre varchar(12) primary key,
id_tg1 BIGINT,
id_tg2 BIGINT,
CONSTRAINT fk_tg1 FOREIGN KEY (id_tg1)
	REFERENCES materia_tg1(id_tg1)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_tg2 FOREIGN KEY(id_tg2)
	REFERENCES materia_tg2(id_tg2)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE avaliacao (
id_avaliacao BIGINT AUTO_INCREMENT PRIMARY KEY,
aluno_email_fatec varchar(128),
id_atividade BIGINT,
nota DECIMAL(4,2),
feedback varchar(256),
CONSTRAINT fk_aluno FOREIGN KEY(aluno_email_fatec)
	REFERENCES aluno(aluno_email_fatec)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_atividade FOREIGN KEY(id_atividade)
	REFERENCES atividade(id_atividade)
    ON DELETE CASCADE ON UPDATE CASCADE
);