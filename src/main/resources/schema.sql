-- Competidor
CREATE TABLE IF NOT EXISTS Competidor(
    id serial primary key,
    nome varchar(100) not null,
    data_nascimento date
);

-- Competicao
CREATE TABLE IF NOT EXISTS Competicao(
    id serial primary key,
    final serial,
    foreign key (final) references EventoEsportivo(id)
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
