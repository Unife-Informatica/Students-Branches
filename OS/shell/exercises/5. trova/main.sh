#!/bin/bash

# Controllo argomenti
if [ "$#" -ne 2 ]; then
  echo "Uso: $0 <directory_assoluta> <nome_file>"
  exit 1
fi

directory="$1"
filename="$2"

# Verifica se la directory è assoluta
if [[ "$directory" != /* ]]; then
  echo "Errore: il percorso deve essere assoluto."
  exit 1
fi

# Verifica se la directory esiste
if [ ! -d "$directory" ]; then
  echo "Errore: la directory specificata non esiste."
  exit 1
fi

# Funzione ricorsiva per cercare il file
cerca_file() {
  local dir="$1"

  for elemento in "$dir"/*; do
    if [ -f "$elemento" ]; then
      if [ "$(basename "$elemento")" = "$filename" ]; then
        echo "$elemento"
      fi
    elif [ -d "$elemento" ]; then
      cerca_file "$elemento" # Ricorsione
    fi
  done
}

# Avvio della ricerca
cerca_file "$directory"
