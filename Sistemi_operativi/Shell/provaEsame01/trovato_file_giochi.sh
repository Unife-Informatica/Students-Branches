#!/bin/bash

if [ $# -ne 1 ];
then
	echo "Errore: uso $1 <nomeCartella>"
	exit 1
fi

dir=$1

if [ ! -d "$dir" ];
then
	echo "Errore: 'dir' non è una cartella o non esiste."
	exit 2
fi

output="$HOME/trovato.txt"

if [ ! -f "$output" ];
then
	> "$output"
fi

max_righe=0
file_max=""

cerca_dir(){
	current_dir="$1"
	for elemento in "$current_dir"/*;
	do
		[ -e "$elemento ] || continue

		case "$elemento" in
			*.txt)
				prima_riga=$(head -n 1 "$elemnto" 2>/dev/null)
				if [ "$prima_riga" = "giochi" ];
				then
					echo "$elemento" >> "$output"
					num_righe=$(wc -l < "$elemento")
					
					if [ "$num_righe" -gt "$max_righe" ];
					then
						max_righe="$num_righe"
						file_max="$elemento"
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
}

cerca_dir "$dir"

if [ -s "$output" ]; then
    echo "Risultati salvati in: $output"
    echo "File con più righe:"
    echo "$file_max ($max_righe righe)"
else
    echo "Nessun file trovato che soddisfi le condizioni."
fi

