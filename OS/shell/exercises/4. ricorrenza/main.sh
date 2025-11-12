#!/bin/bash

# servono almeno due argomenti
if [ "$#" -lt 2 ]; then
  echo "Uso: $0 <file> <parola1> [parola2] ..."
  exit 1
fi

file="$1" # passo a file il primo parametro
shift     # elimino il primo argomento della lista

# il primo argomento deve essere un file leggibile
if [ ! -r "$file" ]; then
  echo "Errore: il file '$file' non esiste o non è leggibile."
  exit 2
fi

# ricerca
for parola in "$@"; do
  count=$(grep -i -c "$parola" "$file")
  echo "Parametro: '$parola' - Ricorrenze: $count"
done
