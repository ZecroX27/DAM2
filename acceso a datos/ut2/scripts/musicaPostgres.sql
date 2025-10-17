
-- Estructura de la taula discos
--

CREATE TABLE discos (
  id SERIAL PRIMARY KEY,
  titol VARCHAR(50) NOT NULL,
  music INTEGER NOT NULL,
  preu DOUBLE PRECISION NOT NULL
);

--
-- Bolcament de dades per a la taula discos
--

INSERT INTO discos (id, titol, music, preu) VALUES
(1, 'Slow train coming', 1, 10),
(5, 'Street Legal', 1, 44),
(6, 'Take the A train', 15, 4);

--
-- Estructura de la taula musics
--

CREATE TABLE musics (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(30) NOT NULL,
  genere VARCHAR(10) NOT NULL
);

--
-- Bolcament de dades per a la taula musics
--

INSERT INTO musics (id, nom, genere) VALUES
(1, 'Bob Dylan', 'pop-rock'),
(2, 'Pink Floyd', 'pop-rock'),
(4, 'Duke Ellington', 'jazz');

-- Reiniciem les seqüències per als IDs autoincrementals
SELECT setval('discos_id_seq', COALESCE((SELECT MAX(id) FROM discos), 1));
SELECT setval('musics_id_seq', COALESCE((SELECT MAX(id) FROM musics), 1));
