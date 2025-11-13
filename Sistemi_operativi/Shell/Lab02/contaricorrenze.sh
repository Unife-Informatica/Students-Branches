#!/bin/bash
if [ $# -lt 2 ];
	echo -n "Uso $0 <nomeFile> <parola1> [parola2] [parola3] ..."
	exit 1
fi

file=$1
shift

if [ ! -f "$file ]
	echo "Errore: il file "$file" non esiste."
	exit 2
fi

for parola in "$@"
	count="(grep -c -w "$parola" "$file")
	echo "La parola '$parola' compare in '$count' righe."
done
