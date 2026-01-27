# Notes

## Race Condition

Nel magazzino ci sono 10 bulloni. Due operatori (thread A e thread B) arrivano nello stesso istante per aggiungere 1 bullone ciascuno.

Senza protezione il thread A legge il valore insieme a B (val = 10). Il thread A calcola e scrive (val = 10 + 1) e B fa lo stesso. Risultato: val = 11. Quindi viene perso un incremento.

Per evitare questa situazione l'operazione di aggiornamento deve essere **atomica**. Per farlo si usa:

## Mutua Esclusione (Mutex) e `synchronized`

Ogni oggetto in java possiede un lucchetto chimato **monitor**. Quando un thread invoca `magazzino.add()`, che è `synchronized`, tenta di acquisire il monitor dell'oggetto.

- Se il Monitor è libero, il thread lo prende, entra, esegue tutto il codice, e alla fine rilascia il Monitor.
- Se il Monitor è già posseduto da un altro thread (che magari sta facendo remove), il nuovo thread viene messo in una lista di attesa (Wait Set) finché il Monitor non si libera.

## Osservazione

All'interno dell'esercizio uso una classe che avvolge `hashMap` in modo da rendere la funzione thread-safe.
