INSERT INTO CLIENTE (Nome, Cognome, Eta, Email, Telefono)
VALUES ('Anna', 'Blu', 26, 'anna.blu@email.it', '3337778888');

DELETE FROM CLIENTE
WHERE ID_Cliente = 1;

UPDATE CLIENTE
SET Email = 'nuova.email@email.it',
  Telefono = '3339990000'
WHERE ID_Cliente = 2;

SELECT * FROM CLIENTE
ORDER BY Nome;

SELECT * FROM CLIENTE
ORDER BY Eta;

INSERT INTO EVENTO (NomeEvento, Data, Ora, Descrizione, PrezzoBiglietto, CapienzaMassima)
VALUES ('Summer Party', '2026-06-10', '22:00:00', 'Festa estiva', 20.00, 180);

DELETE FROM EVENTO
WHERE ID_Evento = 3;

UPDATE EVENTO
SET PrezzoBiglietto = 18.00,
  CapienzaMassima = 200
WHERE ID_Evento = 2;

SELECT * FROM EVENTO
WHERE Data >= '2026-02-20';

SELECT * FROM EVENTO
WHERE PrezzoBiglietto <= 20.00;

INSERT INTO BIGLIETTO (DataAcquisto, PrezzoPagato, ID_Cliente, ID_Evento)
VALUES ('2026-02-21', 20.00, 1, 2);

SELECT CapienzaMassima - COUNT(B.ID_Biglietto) AS PostiDisponibili
FROM EVENTO E
LEFT JOIN BIGLIETTO B ON E.ID_Evento = B.ID_Evento
WHERE E.ID_Evento = 2
GROUP BY E.CapienzaMassima;

SELECT C.Nome, C.Cognome, E.NomeEvento, B.DataAcquisto
FROM BIGLIETTO B
JOIN CLIENTE C ON B.ID_Cliente = C.ID_Cliente
JOIN EVENTO E ON B.ID_Evento = E.ID_Evento;

SELECT E.NomeEvento, COUNT(B.ID_Biglietto) AS BigliettiVenduti
FROM EVENTO E
LEFT JOIN BIGLIETTO B ON E.ID_Evento = B.ID_Evento
GROUP BY E.ID_Evento;

SELECT SUM(PrezzoPagato) AS TotaleVendite
FROM BIGLIETTO
WHERE DataAcquisto BETWEEN '2026-02-01' AND '2026-02-28';

SELECT E.NomeEvento, SUM(B.PrezzoPagato) AS TotaleVendite
FROM BIGLIETTO B
JOIN EVENTO E ON B.ID_Evento = E.ID_Evento
GROUP BY E.ID_Evento;

SELECT C.Nome, C.Cognome, SUM(B.PrezzoPagato) AS TotaleSpeso
FROM BIGLIETTO B
JOIN CLIENTE C ON B.ID_Cliente = C.ID_Cliente
GROUP BY C.ID_Cliente;

SELECT C.Nome, C.Cognome, COUNT(B.ID_Biglietto) AS NumeroBiglietti
FROM CLIENTE C
JOIN BIGLIETTO B ON C.ID_Cliente = B.ID_Cliente
GROUP BY C.ID_Cliente
ORDER BY NumeroBiglietti DESC;

SELECT AVG(C.Eta) AS EtaMedia
FROM CLIENTE C
JOIN BIGLIETTO B ON C.ID_Cliente = B.ID_Cliente;