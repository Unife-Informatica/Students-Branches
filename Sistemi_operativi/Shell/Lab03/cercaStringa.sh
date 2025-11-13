#!/bin/bash

stringa=$1
dir=$2
num=$3

cd "$dir" || exit 1

# Creazione di un contatore
count=0

# Ciclo su tutti i file .txt
for file in *.txt;
do
	[ -e "$file" ] || continue # ignora se non ci sono file
	if [ -f "$file" ] && [ -r "$file" ];
	then
		# Conto le righe che contengono la stringa
		righe_match=$(grep -c "$stringa" "$file")
		if [ "$righe_match" -ge "$num" ];
		then
			count=$((count + 1))
		fi
	fi
done

# Confronto il massimo
max=$(cat "$OLDPWD/max_counter.tmp")
if [ -z "$max" ];
then
	max=0
fi

if [ "$count" -gt "$max" ];
then
	echo "$count" > "$OLDPWD/max_counter.tmp"
	echo "$PWD" > "$OLDPWD/max_dirname.tmp"
fi

# Ricorsione
for subdir in *;
do
	if [ -d "$subdir" ] && [ -x "$subdir" ];
	then
		cercaStringa.sh "$stringa" "$PWD/$subdir" "$num"
	fi
done
