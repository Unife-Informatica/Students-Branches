# Comunicazione - `pipe()`

è un numero intero che identifica in modo univoco un file aperto all'interno di un processo.

## Come funziona
Quando un processo apre un file (es. `open()`, `pipe()`), il kernel crea una struttura che contiene:
- percorso del file
- posizione del file
- i permessi

---

# PIPE
è un meccanismo di comunicazione interprocesso che permette a due processi di scambiarsi dati. L'output di uno diventa l'input dell'altro.
Una pipe è definita da due estremi:
- `f[0]` -> estremo di lettura
- `f[1]` -> estremo di scrittura

## Come crearla
```c
int pipe(int fd[2]);
```
Ritorna `0` se ha successo, `-1` se c'è un errore.
Dopo la chiamata `f[0]` e `f[1]` assumono il valore di lettura e scrittura.
