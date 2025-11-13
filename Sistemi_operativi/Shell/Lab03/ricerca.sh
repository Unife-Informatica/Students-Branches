#!/bin/bash

# Parametri
if [ $# -lt 4 ];
then
	echo "Uso: $0 <num> <dirSorgente> <dirDestinazione> <ext1> [ext2 ... extN]"
	exit 1
fi

num=$1
shift
dirSorgente=$1
shift
dirDestinazione=$1
shift
estensioni="$@"

cd "$dirCorrente" || exit 2

# Ciclo su ogni estensione
for ext int $estensioni;
do
	for file in *"$ext";
	do
		# Se il file esiste davvero (evita errori su pattern non trovati)
		if [ -f "$file" ];
		then
			# Controllo permessi di lettura e numero righe
			if [ -r "$file ];
			then
				righe=$(wc -l < "$file")
				if [ "$righe" -gt "$num" ];
				then
					# Copio file e registro nel file temporaneo
					cp "$file "$dirDestinazione"
					echo "$dirCorrente/$file >> /tmp/counter.tmp
				fi
			fi
		fi
	done
done

# Ricorsione nelle sottodirectory
for subdir in *;
do
	if [ -d "$subdir" ] && [ -x "$subdir" ];
	then
		ricerca.sh "$num" "$(realpath "$subdir")" "$dirDestinazione" $estensioni
	fi
done
