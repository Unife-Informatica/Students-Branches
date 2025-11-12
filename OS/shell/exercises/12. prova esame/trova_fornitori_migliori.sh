#!/bin/bash

dir=$1
cod_parte=$2
num=$3

if [[ $# != 3 ]]; then
  echo "uso: $0 <dir> <cod_parte> <num>"
  exit 1
fi

if [[ ! -d "$dir" ]]; then
  echo "[Errore]: $dir non esiste."
  exit 1
fi

if [[ "$dir" != /* ]]; then
  echo "[Errore]: inserire una directory assoluta"
  exit 1
fi

if [[ ! "$num" =~ ^[0-9]+$ ]]; then
  echo "[Errore]: \"$num\" non è un numero."
  exit 1
fi

echo "" >/tmp/max_forniture
echo 0 >/tmp/max_counter

./trova_fornitori_migliori_aux.sh "$dir" "$cod_parte" "$num"

echo "Max fornitore = $(cat /tmp/max_fornitore): $(cat /tmp/max_counter)"

rm -f /tmp/max_forniture /tmp/max_counter
