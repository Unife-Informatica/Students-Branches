# Utilizzo

## Selezione algoritmi ordinamento da testare

Per scegliere gli algoritmi da testare, modifica il contenuto della matrice `algos` e della variabile `n_algorithms` nella funzione `init`.

Ogni algoritmo è identificato da una stringa; quest'ultima viene associata all'implementazione in `select_algorithm`. 

## Esecuzione

Compila con `gcc sort.c -lm`.

Esegui con `./a.out`, seguendo le istruzioni per inserire la configurazione degli esperimenti.

Il programma scrive i vari tempi misurati nel file `report.txt`. In particolare, la primissima riga codifica le ascisse di un grafico, mentre le righe successive sono i tempi (le ordinate) per i vari ordinamenti, nell'ordine di comparsa nella lista `algos` della funzione `init`.

Per ottenere un grafico `sorting_experiments.png`, puoi eseguire lo script python `plotter.py` con qualsiasi versione di python; l'unica dipendenza richiesta è la libreria `matplotlib`.

Attenzione: le stringhe nella matrice `algos` della funzione `init` (nel codice C) devono coincidere con quelle della lista `algos` di `plotter.py`.
