#!/bin/bash

if [[ $# -lt 3 ]]; then
  echo "[Uso]: $0 <abs_dir> <stringa> ...[file_name]"
  exit 1
fi

dir=$1
stringa=$2

if [[ ! -d "$dir" ]]; then
  echo "[Errore]: la directory: $1 non esiste"
  exit 1
fi

if [[ "$dir" != /* ]]; then
  echo "[Errore]: la directory inserita non è assoluta"
  exit 1
fi

shift 2

for file_name in $@; do
  if [[ ! "$file_name" =~ ^[a-z]+$ ]]; then
    echo "[Errore]: $file_name non corretto"
    exit 1
  fi
done

./copylines_aux.sh "$dir" "$stringa" $@
