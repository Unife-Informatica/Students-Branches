#!/bin/bash

if [ $# -lt 1 ];
then
	echo "Errore: uso $0 <directory>"
	exit 1;
fi

dir=$1

if [ ! -d "$dir" ];
then
	echo "Errore: $dir non è una directory o non esiste."
	exit 1
fi

output="$HOME/trovato.txt"
> "$output"

max_righe=0
file_max=""

cerca_file(){
	current_dir="$1"
	contatore=0
	for elemento in "$current_dir"/*;
	do
		case "$elemento" in
			*.txt)
				if [ -r "$elemento" ];
				then
					prima_riga=$(head -n 1 "$elemento")
					if [ "$prima_riga" = "giochi" ];
					then
						echo "$(basename "$elemento")" >> "$output"
						contatore=$(wc -l < "$elemento")

						if [ "$contatore" -gt "$max_righe" ];
                                		then
                                        		max_righe="$contatore"
                                        		file_max="$elemento"
                                		fi
					fi
				fi
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
    echo "Risultati salvati in: $output"
    echo "File con più righe:"
    echo "$file_max ($max_righe righe)"
else
    echo "Nessun file trovato che soddisfi le condizioni."
fi


