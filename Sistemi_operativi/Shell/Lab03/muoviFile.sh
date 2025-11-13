#!/bin/bash

# Controllo parametri
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

# Controllo directory assoluta
if [[ "$dirSorgente" != /* || "$dirDestinazione" != /* ]];
then
	echo "Errore: le directory devono essere percorsi assoluti."
	exit 2
fi

# Controllo esistenza directory
if [ != -d "$dirSorgente" ];
then
	echo "Errore: la directory sorgente non esiste."
	exit 3
fi

if [ != -d "$dirDestinazione" ];
	echo "Errore: la directory destinazione non esiste."
	exit 4
fi

# Aggiungo directory corrente al PATH
PATH="$PATH:$(pwd)"
export PATH

# Chiamata ricorsiva a ricerca.sh
ricerca.sh "$num" "$dirSorgente" "$dirDestinazione" $estensioni

# Stampa risultato e pulizia
echo "Totale file trovati e spostati: $(wc -l < "$tmpfile")"
rm -f "$tmpfile"
