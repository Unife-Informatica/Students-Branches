-- Inserisce un nuovo cliente nel DB
INSERT INTO CLIENTE (Nome, Cognome, Eta, Email, Telefono)
VALUES ('Anna', 'Blu', 26, 'anna.blu@email.it', '3337778888');

-- Elimina un cliente utilizzando il suo ID
DELETE FROM CLIENTE
WHERE ID_Cliente = 1;

-- Aggiorna email e numero di telefono di un cliente
UPDATE CLIENTE
SET Email = 'nuova.email@email.it',
  Telefono = '3339990000'
WHERE ID_Cliente = 2;

-- Visualizza tutti i clienti ordinati per nome
SELECT * FROM CLIENTE
ORDER BY Nome;

-- Visualizza tutti i clienti ordinati per età
SELECT * FROM CLIENTE
ORDER BY Eta;

-- Inserisce un nuovo evento con i relativi dettagli
INSERT INTO EVENTO (NomeEvento, Data, Ora, Descrizione, PrezzoBiglietto, CapienzaMassima)
VALUES ('Summer Party', '2026-06-10', '22:00:00', 'Festa estiva', 20.00, 180);

-- Elimina un evento tramite il suo id
DELETE FROM EVENTO
WHERE ID_Evento = 3;

-- Aggiorna il prezzo del biglietto e la capienza di un evento
UPDATE EVENTO
SET PrezzoBiglietto = 18.00,
  CapienzaMassima = 200
WHERE ID_Evento = 2;

-- Visualizza gli eventi a partire da una certa data
SELECT * FROM EVENTO
WHERE Data >= '2026-02-20';

-- Visualizza gli eventi con prezzo del biglietto inferiore o uguale ad un prezzo
SELECT * FROM EVENTO
WHERE PrezzoBiglietto <= 20.00;

-- Registra la vendita di un biglietto associando cliente ed evento
INSERT INTO BIGLIETTO (DataAcquisto, PrezzoPagato, ID_Cliente, ID_Evento)
VALUES ('2026-02-21', 20.00, 1, 2);

-- Calcola il numero di posti ancora disponibili per un evento specifico
SELECT CapienzaMassima - COUNT(B.ID_Biglietto) AS PostiDisponibili
FROM EVENTO E
LEFT JOIN BIGLIETTO B ON E.ID_Evento = B.ID_Evento
WHERE E.ID_Evento = 2
GROUP BY E.CapienzaMassima;

-- Visualizza l'elenco dei biglietti venduti con informazioni su cliente ed evento
SELECT C.Nome, C.Cognome, E.NomeEvento, B.DataAcquisto
FROM BIGLIETTO B
JOIN CLIENTE C ON B.ID_Cliente = C.ID_Cliente
JOIN EVENTO E ON B.ID_Evento = E.ID_Evento;

-- Mostra il numero totale di biglietti venduti per ogni evento
SELECT E.NomeEvento, COUNT(B.ID_Biglietto) AS BigliettiVenduti
FROM EVENTO E
LEFT JOIN BIGLIETTO B ON E.ID_Evento = B.ID_Evento
GROUP BY E.ID_Evento;

-- Calcola il totale delle vendite in un determinato periodo
SELECT SUM(PrezzoPagato) AS TotaleVendite
FROM BIGLIETTO
WHERE DataAcquisto BETWEEN '2026-02-01' AND '2026-02-28';

-- Calcola l'incasso totale per ciascun evento
SELECT E.NomeEvento, SUM(B.PrezzoPagato) AS TotaleVendite
FROM BIGLIETTO B
JOIN EVENTO E ON B.ID_Evento = E.ID_Evento
GROUP BY E.ID_Evento;

-- Calcola quanto ha speso complessivamente ogni cliente
SELECT C.Nome, C.Cognome, SUM(B.PrezzoPagato) AS TotaleSpeso
FROM BIGLIETTO B
JOIN CLIENTE C ON B.ID_Cliente = C.ID_Cliente
GROUP BY C.ID_Cliente;

-- Individua i clienti più assidui in base al numero di biglietti acquistati
SELECT C.Nome, C.Cognome, COUNT(B.ID_Biglietto) AS NumeroBiglietti
FROM CLIENTE C
JOIN BIGLIETTO B ON C.ID_Cliente = B.ID_Cliente
GROUP BY C.ID_Cliente
ORDER BY NumeroBiglietti DESC;

-- Calcola l'età media dei clienti che hanno partecipato agli eventi
SELECT AVG(C.Eta) AS EtaMedia
FROM CLIENTE C
JOIN BIGLIETTO B ON C.ID_Cliente = B.ID_Cliente;

-- Mostra i tre eventi con l'incasso totale più alto
SELECT E.NomeEvento, SUM(B.PrezzoPagato) AS IncassoTotale
FROM EVENTO E
JOIN BIGLIETTO B ON E.ID_Evento = B.ID_Evento
GROUP BY E.ID_Evento
ORDER BY IncassoTotale DESC
LIMIT 3;

-- Calcola il prezzo medio effettivamente pagato per ciascun evento
SELECT E.NomeEvento, AVG(B.PrezzoPagato) AS PrezzoMedioPagato
FROM EVENTO E
JOIN BIGLIETTO B ON E.ID_Evento = B.ID_Evento
GROUP BY E.ID_Evento
ORDER BY PrezzoMedioPagato DESC;