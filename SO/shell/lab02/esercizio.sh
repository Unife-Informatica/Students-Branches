#!/bin/sh

# 1. Verifica argomenti (almeno 2)
if test $# -lt 2
then
    echo "Uso: $0 <nomeFile> <ricerca>..."
    exit 1
fi

# 2. Controllo che il primo argomento sia un file (Niente spazi qui!)
file=$1
if test ! -f "$file"
then
    echo "Errore: '$file' non è un file valido"
    exit 2
fi

# 3. Rimuovo il primo argomento ($1 diventa il vecchio $2)
shift

# 4. Ricerca pattern
echo "Controllo file: $file"
for i in "$*"  # "$@" è più sicuro di $* per gestire parametri con spazi
do
    # Eseguo il conteggio (Niente spazi attorno a '=')
    count=$(grep -io "$i" "$file"|wc -l)
    echo "Parametro: $i | Ricorrenze: $count"
done

