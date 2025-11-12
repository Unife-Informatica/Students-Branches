#!/bin/bash

# Controllo che ci siano almeno 4 argomenti
if [ "$#" -lt 4 ]; then
  echo "Uso: $0 <num> <sorgente> <destinazione> <.ext1> [.ext2 ...]"
  exit 1
fi

num=$1
sorgente=$2
destinazione=$3

shift 3

# Controllo che la cartella sorgente esista
if [ ! -d "$sorgente" ]; then
  echo "Errore: la cartella sorgente non esiste"
  exit 1
fi

# Se la cartella destinazione non esiste, la creo
if [ ! -d "$destinazione" ]; then
  mkdir -p "$destinazione"
fi

# Per ogni estensione passata
for estensione in "$@"; do
  # Controllo che inizi con punto
  if [[ "$estensione" != .* ]]; then
    echo "Errore: l'estensione '$estensione' deve iniziare con un punto"
    exit 1
  fi

  # Conta quanti file abbiamo già spostato
  count=0

  # Cerca file con quella estensione nella cartella sorgente
  for file in "$sorgente"/*"$estensione"; do
    # Se non trova file, passa oltre
    [ -e "$file" ] || continue

    # Se non abbiamo ancora raggiunto il limite, sposta il file
    if [ "$count" -lt "$num" ]; then
      mv "$file" "$destinazione/"
      echo "Spostato: $file"
      ((count++))
    fi
  done
done
