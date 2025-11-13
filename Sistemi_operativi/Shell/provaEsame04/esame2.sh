#!/bin/bash

if [ $# -ne 3 ];
then
	echo "Errore: uso $0 <genere> <tipo> <anno>"
	exit 1
fi

genere="$1"
tipo="$2"
anno="$3"

if [ ! -d "$anno" ];
then
	echo "Errore: $anno non è una directory o non esiste."
	exit 2
fi

output="$HOME/risultati.txt"
> "$output"


max_titolo=0
nome_mese_max=""

cerca_dir(){
	current_dir="$1"
	for elemento in "$current_dir"/*;
	do
		case "$elemento" in
			*.txt)
				mese=$(basename "$elemento")
				max=0
				while read voto genere_e titolo casa_prod tipo_a durata altro;
				do
					if [ "$genere_a" = "$genere" ] && [ "$tipo_a" = "$tipo" ];
					then
						echo "$voto $titolo $durata" >> "$output"
						max=$(expr "$max" + 1)
					fi
				done < "$elemento"
				if [ "$max" -gt "max_titolo" ];
				then
					max_titolo="$max"
					nome_mese_max="$mese"
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

cerca_dir "$anno"


if [ -s "$output" ]; then
    echo "Contenuti trovati per '$genere' ($tipo):"
    echo "----------------------------------------"
    sort -nr "$output"
    echo "----------------------------------------"
    echo "Mese con più titoli di interesse: $nome_mese_max ($max_titolo titoli)"
else
    echo "Nessun contenuto trovato per genere '$genere' e tipo '$tipo'."
fi
