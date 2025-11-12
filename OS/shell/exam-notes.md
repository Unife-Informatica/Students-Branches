# Appunti

## Struttura base

1. **Definizione interprete**:

   ```bash
   #!/bin/bash
   ```

2. **Controllo argomenti**:

   ```bash
   if [ $# -ne 1 ]; then
     echo "Uso: $0 argomenti"
     exit 1
   fi

    if [[ "$1" =~ ^[0-9]+$ ]]; then
       echo "È un numero intero positivo"
    fi
   ```

3. **Uscita controllata**:

   ```bash
   exit 0   # successo
   exit 1   # errore
   ```

---

## File e Directory

| Obiettivo                              | Comando                | Esempio                              |
| -------------------------------------- | ---------------------- | ------------------------------------ |
| Estrarre il nome della directory padre | `dirname`              | `dirname /path/file.log → /path`     |
| Estrarre solo il nome del file         | `basename`             | `basename /path/file.log → file.log` |
| Verificare se un file esiste           | `[ -f "$file" ]`       |                                      |
| Verificare se una directory esiste     | `[ -d "$dir" ]`        |                                      |
| Mostrare i file con `.log`             | `ls *.log 2>/dev/null` |                                      |

---

## Testo

| Operazione                         | Comando          | Esempio                                                                                |
| ---------------------------------- | ---------------- | -------------------------------------------------------------------------------------- |
| Estrarre colonne (CSV, separatore) | `cut -d ',' -f3` | Estrae 3° campo                                                                        |
| Filtrare righe con pattern         | `grep "venduto"` | Cerca righe con parola                                                                 |
| Ordinare risultati                 | `sort`           | `sort elenco.txt`                                                                      |
| Contare righe                      | `wc -l`          | `wc -l file`                                                                           |
| Rimozione/sostituzione carattere   | `tr`             | `echo "#titolo" \| tr -d '#'` toglie l'#<br>`echo "a,b,c" \| tr ',' ' '` sostituisce , |

---

## Condizioni

```bash
if [ condizione ]; then
  ...
elif [ altra_condizione ]; then
  ...
else
  ...
fi
```

Confronti numerici: `-eq -ne -gt -lt -ge -le`
Confronti stringhe: `=` `!=` `-z` `-n`
Per info: `man test`

---

## Cicli

```bash
for f in *.log; do
  echo "$f"
done
```

---

## Funzioni

```bash
conta_file() {
    local dir="$1"
    local count=$(ls "$dir" | wc -l)
    echo "$count"
}

cartella="/tmp"
num=$(conta_file "$cartella")
echo "Ci sono $num file in $cartella"
```

---

## I/O

| Operazione                     | Sintassi | Esempio                         |
| ------------------------------ | -------- | ------------------------------- |
| Scrivere su file (sovrascrive) | `>`      | `echo "Riga" > file.txt`        |
| Aggiungere a file              | `>>`     | `echo "Nuova riga" >> file.txt` |
| Reindirizzare errore           | `2>`     | `comando 2> errori.txt`         |
| Reindirizzare tutto            | `&>`     | `comando &> output.txt`         |

**Input**: `read var_name`

| Variabile   | Significato                                                   |
| ----------- | ------------------------------------------------------------- |
| `$@`        | Tutti gli argomenti come lista (mantiene spazi e separazione) |
| `$*`        | Tutti gli argomenti come un’unica stringa                     |
| `$#`        | Numero totale di argomenti passati allo script                |
| `$?`        | Codice di uscita dell’ultimo comando eseguito                 |
| `$0`        | Nome dello script (come è stato invocato)                     |
| `$1 ... $N` | Singoli argomenti (primo, secondo, ecc.)                      |
| `$$`        | PID (Process ID) del processo corrente                        |
| `$!`        | PID dell’ultimo processo eseguito in background               |

---

## Comandi

| Comando | Cosa fa                                     | Uso tipico                             |
| ------- | ------------------------------------------- | -------------------------------------- |
| `ps`    | Mostra i processi in esecuzione sul sistema | Controllare o filtrare processi attivi |

---

## Formule

| Scopo                                     | One-liner                 |
| ----------------------------------------- | ------------------------- |
| Estrarre solo i campi della terza colonna | `cut -d ',' -f3 file.log` |

---

## Accortezze

| Categoria                      | Sintassi / Esempio              | Descrizione / Note                                 |
| ------------------------------ | ------------------------------- | -------------------------------------------------- |
| **Sostituzione di comandi**    | `` VAR=`ls` `` <br> `VAR=$(ls)` | Consigliato `$(...)` invece dei backtick `` ` ` `` |
| **Espansione variabili**       | `$VAR` <br> `${VAR}`            | `${VAR}` è utile per concatenare: `${USER}_home`.  |
| **Aritmetica**                 | `c=$((a + b))`                  | Usa `$((...))` per somme, sottrazioni, ecc.        |
| **Quote**                      | `"..."` e `'...'`               | `"` espande variabili, `'` no.                     |
| **Virgolette nelle variabili** | `"${VAR}"`                      | Evita problemi con spazi nei nomi di file.         |
