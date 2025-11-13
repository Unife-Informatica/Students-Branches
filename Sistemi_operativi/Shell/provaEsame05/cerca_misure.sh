#!/bin/bash

if [ $# -lt 2 ];
then
	echo "Errore: uso $0 <nomeCartella> <header>"
	exit 1;
fi

dir=$1
header=$2

if [ ! -d "$dir" ];
then
	echo "Errore: '$dir' non è una directory o n on esiste."
	exit 2;
fi

output="$HOME/misure.txt"
> "$output"

max_file=0
dir_max=""

cerca_dir(){
	current_dir="$1"
	contatore=0

	for elemento in "$current_dir"/*;
	do
		case "$elemento" in
			*.log)
				if [ -r "$elemento" ] && [ -w "$elemento" ];
				then
					prima_riga=$(head -n 1 "$elemento")
					if [ "$prima_riga" = "$header" ];
					then
						nome_file=$(basename "$elemento")
						echo "$(realpath "$elemento") "$nome_file"" >> $output
						contatore=$(expr "$contatore" + 1)
					fi
				fi
			;;
			*)
				if [ -d "$elemento" ];
				then
					cerca_dir "$elemento"
				fi
			;;
		esac
	done

	if [ "$count_dir" -gt "$max_file" ];
	then
    		max_file="$count_dir"
    		dir_max="$current_dir"
	fi
}


cerca_dir "$dir"

if [ -s "$output" ];
then
	echo "Risultati salvati in: $output"
	echo "File con più file:"
	echo "$dir_max ($max_file file)"
else
	echo "Nessun file trovato che soddisfi le condizioni."
fi
