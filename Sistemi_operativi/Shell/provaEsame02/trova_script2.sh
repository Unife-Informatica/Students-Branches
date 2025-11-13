#!/bin/bash

if [ $# -lt 1 ];
then
	echo "Errore: uso $0 <dir>"
	exit 1
fi

dir="$1"

if [ ! -d "$dir" ];
then
	echo "Errore: $dir non è una directory o non esiste."
	exit 2
fi

output="$HOME/script.txt"
> "$output"

max_file=0
max_dir=""

cerca_dir(){
	current_dir="$1"
	contatore=0
	for elemento in "$current_dir"/*;
	do
		case "$elemento" in
			*.sh)
				if [ -r "$elemento" ] && [ -w "$elemento" ];
				then
					prima_riga=$(head -n 1 "$elemento")
					if [ "$prima_riga" = "#!/bin/bash" ];
					then
						echo "$(basename "$elemento")" >> "$output"
						contatore=$(expr contatore + 1)
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
	if [ "$contatore" -gt "$max_file" ];
	then
		max_file="$contatore"
		max_dir="$current_dir"
	fi
}

cerca_dir "$dir"

if [ -s "$output" ];
then
	echo "File di script trovati salvati in: $output"
	echo "Sottodirectory con più script Bash: "
	echo "$dir_max ($max_file file trovati)
else
	echo "Nessuno script trovato che soddisfi le condizioni."
fi
