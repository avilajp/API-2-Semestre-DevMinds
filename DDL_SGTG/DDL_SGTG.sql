CREATE SCHEMA sgtg;

USE sgtg;

CREATE TABLE atividade (
atividade_nome varchar(64),
atividade_data_entrega datetime NOT NULL,
descricao varchar(128) NOT NULL,
nota DECIMAL(4,2),
PRIMARY KEY (atividade_nome, atividade_data_entrega)
);

CREATE TABLE aluno (
aluno_email_fatec varchar(128) PRIMARY KEY,
nome varchar(128)
);

CREATE TABLE materia_tg1 (
tg1_id BIGINT auto_increment PRIMARY KEY,
tipo varchar(32) NOT NULL,
problema varchar(128),
empresa varchar(64),
disciplina varchar(64),
aluno_email_fatec varchar(128),
atividade_nome varchar(64),
atividade_data_entrega datetime NOT NULL,

CONSTRAINT fk_atividade_tg1 FOREIGN KEY (atividade_nome, atividade_data_entrega)
	REFERENCES atividade (atividade_nome, atividade_data_entrega)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_aluno_tg1 FOREIGN KEY (aluno_email_fatec)
	REFERENCES aluno(aluno_email_fatec)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE materia_tg2 (
tg2_id BIGINT auto_increment PRIMARY KEY,
tipo varchar(32) NOT NULL,
problema varchar(128),
empresa varchar(64),
disciplina varchar(64),
aluno_email_fatec varchar(128),
atividade_nome varchar(64),
atividade_data_entrega datetime NOT NULL,

CONSTRAINT fk_atividade_tg2 FOREIGN KEY (atividade_nome, atividade_data_entrega)
	REFERENCES atividade (atividade_nome, atividade_data_entrega)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_aluno_tg2 FOREIGN KEY (aluno_email_fatec)
	REFERENCES aluno(aluno_email_fatec)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE semestre (
nome varchar(12) primary key,
tg1_id BIGINT,
tg2_id BIGINT,
CONSTRAINT fk_tg1 FOREIGN KEY (tg1_id)
	REFERENCES materia_tg1(tg1_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_tg2 FOREIGN KEY(tg2_id)
	REFERENCES materia_tg2(tg2_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE aluno
ADD COLUMN atividade_nome varchar(64),
ADD COLUMN atividade_data_entrega datetime NOT NULL,
ADD CONSTRAINT fk_atividade FOREIGN KEY (atividade_nome, atividade_data_entrega)
	REFERENCES atividade(atividade_nome, atividade_data_entrega)
    ON DELETE CASCADE ON UPDATE CASCADE;