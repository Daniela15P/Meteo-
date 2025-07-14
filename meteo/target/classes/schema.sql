CREATE DATABASE meteo;
GRANT ALL ON meteo.* to 'its_2025'@'localhost';

CREATE TABLE meteo(
	Id INT auto_increment primary key,
    Citta varchar(50),
    Descrizione text,
    Temperatura decimal(10,2)
    );

