# Comandi

## Filtri
| Comando | Descrizione                             | Esempi                                                                              |
|---------|-----------------------------------------|-------------------------------------------------------------------------------------|
| `sort`  | riordina le righe                       | sort <file_name> # riordina crescente<br>sort -r <file_name> # riordina decrescente |
| `diff`  | differenza di contenuto tra due file    | diff <file1> <file2>                                                                |
| `grep`  | ricerca di un testi in un file          |                                                                                     |
| `rev`   | inverte l'ordine delle linee di un file |                                                                                     |
| `cut`   | seleziona colonne da file               |                                                                                     |
|         |                                         |                                                                                     |


## Utenti e Processi
| Comando | Descrizione                                           | Esempi                                                                                                                                                                                    |
|---------|-------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `wc`    | numero linee (`-l`), parole (`-w`) o caratteri (`-c`) | wc -l <file_name>                                                                                                                                                                         |
| `who`   | utenti attualmente collegati al sistema               |                                                                                                                                                                                           |
| `ps`    | lista dei processi attivi                             | ps a # processo degli altri utenti<br>ps u # fornisce nome di chi ha lanciato il processo e orario<br>ps x # processi senza terminale di controllo<br>ps -o cmd # seleziona la colonna cmd|
| `kill`  | terminazione forzata di un processo                   | kill -9 \<PID>                                                                                                                                                                            |
