#!/bin/bash

if [ $# -ne 1 ];
then
	echo "Uso: $1 <nomeDirectory>"
	exit 1;
fi

dir=$1

if [ ! -d "$1" ];
then
	echo "Errore: "$dir" non è una directory o non esiste."
	exit 2;
fi

output="$HOME/script.txt"
if [ ! -f "$output" ];
then
	> "$output"
fi

n_max_file=0
nome_directory=""

cerca_dir(){
	for elemento in "$dir"/*;
	do
		case "$elemento" in
			*.sh)
				prima_riga=$(head -n 1 "$elemento")
				if [ "$prima_riga" = "#!/bin/bash" ];
				then
					echo "$elemento" >> "$output"
					num_file=$(expr "$num_file" + 1)
				fi
			;;
			if [ "$num_file" -gt "$n_max_file" ];
			then
				n_max_file="$num_file"
				nome_directory="$elemento"
			fi
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
    echo "Directory con più file:"
    echo "$nome_directory ($n_max_file file)"
else
    echo "Nessun file trovato che soddisfi le condizioni."
fi
