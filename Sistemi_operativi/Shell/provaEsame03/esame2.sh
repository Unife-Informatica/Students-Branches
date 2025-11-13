#!/bin/bash

if [ $# -lt 2 ];
then
	echo "Errore: uso $0 <nome> <anno>"
	exit 1;
fi

nome=$1
anno=$2

if [ ! -d "$anno" ];
then
	echo "Errore: $anno non è una directory o non esiste."
	exit 2
fi

output="$HOME/fiumilog.txt"
> "$output"

min_liv=9999999
corso_acqua_min=""

cerca_file(){
	current_dir="$1"
	min=0
	nome_min=""
	for elemento in "$current_dir"/*
		case "$elemento" in
			*.txt)
				while read livello nome_corso loc soglia timestamp altro;
				do
					if [ "$nome" = "nome_corso" ];
					then
						echo "$livello $loc $timestamp" >> "$output"
						nome_min=$(basename "$nome_corso")
						min="$livello"
						
						if [ "$min" -lt "$min_liv" ];
						then
							min_liv="$min"
							corso_acqua_min="$nome_min"
						fi
					fi
				done < "$elemento"
			;;
			*)
				if [ -d "$elemento" ];
				then
					cerca_file "$elemento"
				fi
			;;
		esac
	done
}

cerca_file "$dir"


if [ -s "$output" ]; then
    echo "Dati estratti in: $output"
    echo "Livello minimo per il corso '$nome': $min_livello"
    echo "Giorno con livello minimo: $file_min"
else
    echo "Nessuna rilevazione trovata per il corso '$nome'."
fi
