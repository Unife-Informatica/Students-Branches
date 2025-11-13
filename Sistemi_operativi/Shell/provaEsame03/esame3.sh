#!/bin/bash

if [ $# -ne 2 ];
then
	echo "Errore: uso $0 <nome> <anno>"
	exit 1
fi

nome="$1"
anno="$2"

if [ ! -d "$anno" ];
then
	echo "Errore: $anno non è una cartella o non esiste."
	exit 2
fi

output="$HOME/fiumilog.txt"
> "$output"

livello_min=99999999
giorno_min=""

export liv loc timestamp output livello_min giorno_min

export PATH=$PATH:$(pwd)

./esame_ric.sh "$anno"

if [ -s "$output" ];
then
	echo "Il giorno con il livello più basso è: ($giorno_min: $livello_min)"
else
	echo "Nessun file trovato che rispecchia le caratteristiche."
