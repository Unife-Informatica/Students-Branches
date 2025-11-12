#!bin/bash

# • Rimuovere tutti i file contenuti in “prova_dir”.

# • Creare un nuovo file con l'elenco degli utenti collegati. Contare il
#   numero di utenti collegati.

# • Creare un file che contenga l'elenco dei processi attivi di tutti
#   gli utenti (compresi quelli senza terminale di controllo), mostrando
#   anche informazioni come il nome dell’utente che ha lanciato il
#   processo (vedi man). Si filtri il file precedentemente creato al fine di
#   visualizzare sullo standard output solo i propri processi (si ipotizzi
#   per semplicità che il file creato non abbia righe "equivoche").

# • In un unico comando, senza creare file di appoggio, contare i
#   processi dell'utente root attualmente in esecuzione (piping).

cd prova_dir                                        # si sposta all'interno della directory prova_dir
rm -rf *                                            # rimuove tutti i file contenuti in prova_dir
who > utenti.txt                                    # crea un file utenti.txt con l'elenco degli utenti collegati
wc -l utenti.txt                                    # conta il numero di utenti collegati
ps -e -o user,pid,cmd --no-headers > processi.txt   # crea un file processi.txt con l'elenco dei processi attivi di tutti gli utenti
grep $USER processi.txt                             # filtra il file processi.txt per visualizzare solo i processi dell'utente corrente
ps -u root --no-headers | wc -l                     # conta i processi dell'utente root attualmente in esecuzione