INSERT INTO CLIENTE (Nome, Cognome, Eta, Email, Telefono) VALUES
('Marco', 'Rossi', 25, 'marco.rossi@email.it', '3331112222'),
('Luca', 'Bianchi', 30, 'luca.bianchi@email.it', '3332223333'),
('Giulia', 'Verdi', 22, 'giulia.verdi@email.it', '3333334444'),
('Sara', 'Neri', 28, 'sara.neri@email.it', '3334445555'),
('Paolo', 'Gialli', 35, 'paolo.gialli@email.it', '3335556666');

INSERT INTO EVENTO (NomeEvento, Data, Ora, Descrizione, PrezzoBiglietto, CapienzaMassima) VALUES
('Serata Disco 80', '2026-02-10', '22:00:00', 'Musica anni 80', 15.00, 100),
('DJ Night', '2026-02-15', '23:00:00', 'DJ set internazionale', 20.00, 150),
('Latin Party', '2026-02-20', '22:30:00', 'Musica latina', 18.00, 120),
('Techno Night', '2026-02-25', '23:30:00', 'Serata techno', 22.00, 200),
('Closing Party', '2026-02-28', '22:00:00', 'Grande festa di chiusura', 25.00, 250);

INSERT INTO BIGLIETTO (DataAcquisto, PrezzoPagato, ID_Cliente, ID_Evento) VALUES
('2026-02-01', 15.00, 1, 1),
('2026-02-02', 20.00, 2, 2),
('2026-02-03', 18.00, 3, 3),
('2026-02-04', 22.00, 4, 4),
('2026-02-05', 25.00, 5, 5);