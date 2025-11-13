#!/bin/bash

# Controllo dei parametri
if [ $# -ne 3 ];
then
	echo "Uso: <stringa> <directory_assoulta> <num>"
	exit 1
fi

stringa=$1
dir=$2
num$3

# Verifica che dir  sia una directory assoluta
if [ "$dir" != /* ];
then
	echo "Errore: il secondo parametro deve essere una directory assoluta."
	exit 2
fi

if [ ! -d "$dir" ];
then
	echo "Errore: '$dir' non esiste o non è una directory."
	exit 3
fi

# Aggiungo la directory corrente al PATH
PATH="$PATH:$(pwd)"
export PATH

# Creazione file temporanei

> max_counter.tmp # numero massimo di file trovati
> max_dirname.tmp # nome directory con più file

# Chiamata allo script ricorsivo
cercaStringa.sh "$stringa" "$dir" "$num"

# Stampa del risultato
echo "Directory con più file che soddisfano le condizioni:"
cat max_dirname.tmp

# Pulizia
rm -f max_counter.tmp max_dirname.tmp
