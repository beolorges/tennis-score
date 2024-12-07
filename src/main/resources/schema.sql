-- DROP ALL TABLES

DROP TABLE IF EXISTS CompeticaoCompetidor;
DROP TABLE IF EXISTS Premiacao;
DROP TABLE IF EXISTS EventoCompetidor;
DROP TABLE IF EXISTS EventoEsportivo;
DROP TABLE IF EXISTS Competicao;
DROP TABLE IF EXISTS Estadio;
DROP TABLE IF EXISTS Competidor;

-- Competidor
CREATE TABLE IF NOT EXISTS Competidor(
    id serial primary key,
    nome varchar(100) not null,
    data_nascimento date
);

-- Competicao
CREATE TABLE IF NOT EXISTS Competicao(
    id serial primary key,
    nome varchar(50) not null
);

-- Estadio
CREATE TABLE IF NOT EXISTS Estadio(
    id serial primary key,
    cep varchar(8) not null,
    nome varchar(30) not null,
    capacidade integer not null,
    site varchar(50)
);

-- Evento Esportivo
CREATE TABLE IF NOT EXISTS EventoEsportivo(
    id serial primary key,
    data timestamp,
    fase varchar(50) not null,
    competicao serial not null,
    estadio serial,
    foreign key (competicao) references Competicao(id),
    foreign key (estadio) references Estadio(id)
);

-- Evento Competidor
CREATE TABLE IF NOT EXISTS EventoCompetidor(
    evento_id serial not null,
    competidor_id serial not null,
    foreign key (evento_id) references EventoEsportivo(id),
    foreign key (competidor_id) references Competidor(id)
);

-- Premiacao
CREATE TABLE IF NOT EXISTS Premiacao(
    id serial primary key,
    competicao serial not null,
    evento_esportivo serial,
    valor real not null,
    vencedor serial,
    foreign key (competicao) references Competicao(id),
    foreign key (evento_esportivo) references EventoEsportivo(id),
    foreign key (vencedor) references Competidor(id)
);

-- Competicao Competidor
CREATE TABLE IF NOT EXISTS CompeticaoCompetidor(
    evento_id serial not null,
    competidor_id serial not null,
    foreign key (evento_id) references EventoEsportivo(id),
    foreign key (competidor_id) references Competidor(id)
);

-- Insert into Competidor
INSERT INTO Competidor (nome, data_nascimento) VALUES
('Alice Silva', '1990-05-12'),
('Carlos Mendes', '1985-08-20'),
('Beatriz Santos', '1992-01-15'),
('Diego Costa', '1995-03-22'),
('Fernanda Lima', '1988-07-10');

-- Insert into Competicao
INSERT INTO Competicao (nome) VALUES
('Campeonato Brasileiro'),
('Copa do Mundo'),
('Liga Nacional'),
('Torneio Estadual');

-- Insert into Estadio
INSERT INTO Estadio (cep, nome, capacidade, site) VALUES
('12345678', 'Estadio Nacional', 70000, 'www.estadionacional.com'),
('87654321', 'Arena Central', 50000, 'www.arenacentral.com'),
('45678912', 'Estadio Olimpico', 80000, NULL),
('32165498', 'Estadio Municipal', 30000, 'www.municipal.com');

-- Insert into EventoEsportivo
INSERT INTO EventoEsportivo (data, fase, competicao, estadio) VALUES
('2024-06-15 15:00:00', 'FASE_DE_GRUPOS', 1, 1),
('2024-06-20 18:00:00', 'QUARTAS_DE_FINAL', 2, 2),
('2024-06-25 20:00:00', 'SEMIFINAL', 3, 3),
('2024-07-01 21:00:00', 'FINAL', 1, 4);

-- Insert into EventoCompetidor
INSERT INTO EventoCompetidor (evento_id, competidor_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 5),
(4, 2),
(4, 3);

-- Insert into Premiacao
INSERT INTO Premiacao (competicao, evento_esportivo, valor, vencedor) VALUES
(1, 4, 500000, 2),
(2, 2, 200000, 3),
(3, 3, 300000, 1),
(4, 1, 100000, 5);

-- Insert into CompeticaoCompetidor
INSERT INTO CompeticaoCompetidor (evento_id, competidor_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 1),
(4, 3),
(4, 2);
