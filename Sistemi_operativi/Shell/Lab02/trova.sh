#!/bin/bash
if [ $# -lt 2];
then
	echo -n "Uso: $0 <directoryAssoluta> <nomeFile>"
	exit 1;
fi

dir=$1
nomeFile=$2

if [ "$dir" != /* ];
then
	echo -n "Errore: il primo parametro non è una directory assoluta."
	exit 2;
fi

if [ ! -d "$dir" ];
then
	echo -n "Errore: il primo parametro non è una directory o non esiste."
	exit 3;
fi

if [ ! -f "$2"];
then
	echo -n "Errore: il secondo parametro non è un file."
	exit 4;
fi

ricerca(){
	local path="$1"
	local file="$2"

	#Scansiona tutti gli elementi della directory corrente
	for entry in "$path"/*;
	do
		#Se è un file, confronta il nome
		if [ -f "$entry" ];
		then
			base=$(basename "$entry")
			if [ "$base" = "$file" ];
			then
				echo -n "Trovato: $(realpath "$entry")"
			fi
		elif [ -d "$entry" ];
		then
			if [ "$entry" != "$path/." ] &&  [ "$entry" != "$path/.." ];
			then
				ricerca "$entry" "$file"
			fi
		fi
	done
}

ricerca "$dir" "$file"

