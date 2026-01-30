# Sistemi Operativi - Compito del 8 giugno 2016

Si progetti un’applicazione concorrente in C che permetta a un utente di
visualizzare le notizie più popolari tra quelle pubblicate sul Web.
L’applicazione deve presentare la seguente interfaccia:

```bash
trova_news dir
```

dove `dir` è un nome assoluto di directory che contiene tutte le informazioni
sulle notizie, conservate in una serie di file di testo, ciascuno dei quali
conterrà le notizie pubblicate in una specifica giornata. Ogni file di testo ha
il nome composto dalla data della giornata, in formato `YYYYMMDD`, seguito
dall’estensione `.txt` (quindi, per esempio, le notizie pubblicate oggi saranno
tutte salvate nel file `20160608.txt`). Ciascuna riga di tali file conterrà tutte
le informazioni relative a una specifica notizia, con (in quest’ordine) il
numero di “like” ricevuti, il titolo della notizia, l’argomento della notizia, il
link al sito Web su cui la notizia è stata pubblicata, ecc.

L’applicazione concorrente deve essere composta da un processo iniziale
`P0` che si interfaccia con l’utente, da cui riceve (via terminale) l’argomento
(ad esempio “politica”, “sport”, “cronaca”, ecc.) e la data di interesse (in formato
`YYYYMMDD`). Per ogni richiesta inserita, il processo `P0` deve quindi creare
due processi figli, `P1` e `P2`. `P1` deve selezionare le notizie di interesse nella
giornata richiesta e inviarle a `P2`, che a sua volta deve restituirle all’utente,
elencandole in ordine decrescente di “like”.

`P0` continua a rispondere alle richieste dell’utente fino all’inserimento della
stringa `"fine"` o alla pressione del tasto `Ctrl-C`. In entrambi i casi, il processo
`P0` deve stampare il numero di richieste servite prima di terminare.
