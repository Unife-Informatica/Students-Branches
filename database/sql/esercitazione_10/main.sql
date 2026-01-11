------------------------
-- QUERY DI CREAZIONE
------------------------
/*
CREATE TABLE medici (
    id INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE specializzazioni (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE medici_specializzazioni (
    id_medico INT,
    id_specializzazione INT,
    PRIMARY KEY (id_medico, id_specializzazione),
    FOREIGN KEY (id_medico) REFERENCES medici(id),
    FOREIGN KEY (id_specializzazione) REFERENCES specializzazioni(id)
);

CREATE TABLE pazienti (
    id INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    data_di_nascita DATE NOT NULL
);

CREATE TABLE visite (
    id INT PRIMARY KEY,
    id_medico INT NOT NULL,
    id_paziente INT NOT NULL,
    data_visita DATE NOT NULL,
    FOREIGN KEY (id_medico) REFERENCES medici(id),
    FOREIGN KEY (id_paziente) REFERENCES pazienti(id)
);

INSERT INTO medici VALUES
    (1, 'Mario', 'Rossi', 'mario.rossi@centromedico.it'),
    (2, 'Laura', 'Bianchi', 'laura.bianchi@centromedico.it'),
    (3, 'Giovanni', 'Verdi', 'giovanni.verdi@centromedico.it'),
    (4, 'Marco', 'Neri', 'marco.neri@centromedico.it'),
    (5, 'Silvia', 'Grasso', 'silvia.grasso@centromedico.it'),
    (6, 'Sarah', 'Giri', 'sarah.giri@centromedico.it'),
    (7, 'Eli', 'Rossi', 'eli.rossi@centromedico.it');

INSERT INTO specializzazioni VALUES
    (1, 'Cardiologia'),
    (2, 'Ginecologia'),
    (3, 'Ortopedia'),
    (4, 'Pediatria'),
    (5, 'Psicologia Clinica');

INSERT INTO medici_specializzazioni VALUES
    (1, 1),
    (1, 3),
    (2, 2),
    (2, 4),
    (3, 1),
    (4, 3),
    (5, 5);

INSERT INTO pazienti VALUES
    (1, 'Marco', 'Rossi', '1990-05-10'),
    (2, 'Laura', 'Bianchi', '1985-11-23'),
    (3, 'Giovanni', 'Verdi', '1978-07-15'),
    (4, 'Silvia', 'Grasso', '2000-02-18'),
    (5, 'Marco', 'Neri', '1982-09-01');

INSERT INTO visite VALUES
    (1, 1, 1, '2023-03-01'),
    (2, 2, 2, '2023-03-02'),
    (3, 3, 3, '2023-03-03'),
    (4, 4, 4, '2023-03-04'),
    (5, 5, 5, '2023-05-18'),
    (6, 1, 5, '2023-05-18'),
    (7, 2, 5, '2023-05-18'),
    (8, 2, 5, '2023-05-18'),
    (9, 2, 1, '2023-05-18'),
    (10, 4, 1, '2023-05-18'),
    (11, 5, 5, '2023-05-18');
*/


------------------------
-- RISOLUZIONE ESERCIZI
------------------------

-- insert into pazienti (id, nome, cognome, data_di_nascita) values (6, "Pietro", "Verdi", "2005-01-01")
-- update medici set email="mario.rossi@gmail.com" where id = 1
-- alter table visite add note VARCHAR(255)
-- update visite set note = "nota casuale" where id <= 3 -- si puo usare `where id in (1, 2, 3)
-- update pazienti set data_di_nascita="1982-09-02" where id = 5
-- select nome, cognome from medici where email like "%centromedico%"
-- select m.id, m.nome, count(v.id_medico) as numero_visite from medici m left join visite v on m.id = v.id_medico group by m.id
-- select p.* from pazienti p join visite v on p.id = v.id_paziente where v.data_visita between '2023-03-01' and '2023-03-31'
-- select s.id, s.nome as specializzazione, COUNT(ms.id_medico) AS numero_medici from specializzazioni s left join medici_specializzazioni ms on s.id = ms.id_specializzazione group by s.id, s.nome order by numero_medici desc;
-- select p.*, m.nome as nome_medico, m.cognome as congome_medico from pazienti p join visite v on p.id = v.id_paziente left join medici m on v.id_medico = m.id
-- select m.* from medici m left join medici_specializzazioni ms on m.id=ms.id_medico where ms.id_specializzazione IS NULL
-- select m.*, count(ms.id_medico) as numero_specializzazioni from medici m left join medici_specializzazioni ms on m.id=ms.id_medico group by m.id
-- select p.*, count(v.id_paziente) as numero_visite from pazienti p left join visite v on p.id = v.id_paziente group by p.id having numero_visite >= 3
-- select m.id, m.nome, m.cognome, m.email, count(distinct v.id_paziente) as numero_pazienti from medici m join visite v on m.id=v.id_medico group by m.id, m.nome, m.cognome, m.email having numero_pazienti>=3;

