#!/bin/bash

if [ $# -lt 3 ];
then
	echo "Errore: uso $0 <genere> <tipo> <anno>"
	exit 1;
fi

genere="$1"
tipo="$2"
anno="$3"

if [ -d "$anno" ];
then
	echo "Errore: '$anno' non è una directory o non esiste."
	exit 2;
fi

risultati="$HOME/risultati.txt"
> "$risultati"

max_titoli=0
mese_max=""

analizza_dir(){
	current_dir="$1"
	for elemento in "$current_dir"/*;
	do
		case "$elemento" in
			*.txt)
				mese=$(basename "$elemento" .txt)
				contatore=0
				while read voto g titolo produzione t durata resto
				do
					if [ "$g" = "$genere ] && [ "$t" = "$tipo" ];
					then
						echo "$voto $titolo $durata" >> "$risultati"
						contatore=$(expr "$contatore" + 1)
					fi
				done < "$elemento"

				if [ "$contatore" -gt "$max_titoli" ]; then
    					max_titoli="$contatore"
    					mese_max="$mese"
				fi
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

if [ -s "$risultati" ]; then
    echo "=== RISULTATI ORDINATI (dal voto più alto al più basso) ==="
    sort -nr "$risultati"    # ordina per voto decrescente (numerico)
    echo "Mese con più titoli di interesse: $mese_max"
    echo "File risultati salvato in: $risultati"
else
    echo "Nessun contenuto trovato per genere '$genere' e tipo '$tipo'."
fi
