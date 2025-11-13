#!/bin/bash

if [ $# -ne 1 ];
then
	echo "Errore: uso $0 <dir>"
	exit 1;
fi

dir="$1"

if [ ! -d "$dir" ];
then
	echo "Errore: $dir non è una directory oppure non esiste."
	exit 2;
fi

output="$HOME/trovato.txt"
> "$output"

max_righe=0
file_max=""

export output max_righe file_max

./trova_file_giochi_ric.sh "$dir"

if [ -s "$output" ];
then
	echo "File con più righe: ($file_max: $max_righe numero righe)"
else
	echo "Nessun file trovato che rispetta le condizioni."
