# Sistemi Operativi – 16 giugno 2021

Si progetti un’applicazione concorrente in C che permetta a un utente di cercare i biglietti
disponibili relativi ai treni verso una certa stazione ferroviaria. L’applicazione deve presentare
la seguente interfaccia:

```
trova_biglietti destinazione N
```

dove destinazione è una stringa che indica il luogo di arrivo e N un intero.
Si supponga che tutti i biglietti acquistabili per uno specifico luogo di arrivo siano raccolti in
un file di testo il cui nome è il luogo stesso, la cui estensione è `.txt` e collocato nella directory

```
/var/local/ticket
```

Tale file contiene le informazioni sui viaggi disponibili verso il luogo in
questione. Quindi, per esempio, i viaggi disponibili verso Padova sono salvati nel file

```
/var/local/ticket/Padova.txt
```

Ciascuna riga di tali file contiene tutte le informazioni relative a
uno specifico biglietto, con (in quest’ordine) il prezzo, la data di partenza (in formato

```
DDMMYYYY
```

), i posti ancora disponibili.

L’applicazione concorrente deve essere composta da un processo iniziale `P0` che si interfaccia
con l’utente, da cui riceve (via terminale) giorno, mese e anno della data di partenza (3 interi)
da visualizzare. Per ogni richiesta inserita, il processo `P0` deve quindi creare tre processi figli,
`P1`, `P2` e `P3`.

`P1` deve selezionare le offerte presenti per la data di interesse e inviarle a `P2`, che
a sua volta deve ordinare le offerte dalla più economica alla più costosa e inviarle a `P3` che
deve restituire all’utente le `N` offerte più economiche.

`P0` continua a rispondere alle richieste dell’utente fino all’inserimento del valore

```
-1
```

(per giorno, mese o anno) oppure alla pressione del tasto

```
Ctrl-C
```

In entrambi i casi, il processo `P0` deve stampare il numero di richieste servite prima di terminare.
