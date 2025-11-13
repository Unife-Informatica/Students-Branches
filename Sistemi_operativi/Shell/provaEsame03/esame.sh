#!/bin/bash

if [ $# -lt 2 ];
then
	echo "Errore: uso $0 <nome_corso_acqua> <nome_directory>"
	exit 1;
fi

nome=$1
anno=$2

if [ ! -d "$anno" ];
then
	echo "Errore: $anno non è una directory o non esiste."
	exit 2
fi

logfile="$HOME/fiumilog.txt"
> "$logfile"

min_livello=9999999
file_min=""

analizza_dir(){
	current_dir="$1"
	for elemento in "$current_dir"/*;
	do
		case "$elemento" in
			*.txt)
				giorno=$(basename "$elemento")
				while read livello corso localita soglia timestamp resto
				do
					if [ "$corso" = "$nome" ];
					then
						echo "$livello $localita $timestamp" >> "$logfile"
						if [ "$livello" -lt "$min_livello" ];
						then
							min_livello="$livello"
							file_min="$giorno"
						fi
					fi
				done < "$elemento"
			;;
			*)
				if [ -d "$elemento" ];
				then
					analizza_dir "$elemento"
				fi
			;;
		esac
	done
}

analizza_dir "$anno"

if [ -s "$logfile" ]; then
    echo "Dati estratti in: $logfile"
    echo "Livello minimo per il corso '$nome': $min_livello"
    echo "Giorno con livello minimo: $file_min"
else
    echo "Nessuna rilevazione trovata per il corso '$nome'."
fi
