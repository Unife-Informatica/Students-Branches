#!/bin/sh

#VERIFICA ARGOMENTI
# due argomenti
if test $# != 2
then
	echo "Uso: esercizio03.sh <dir> <file>"
	exit 1
fi

#il primo argomento e' una directory assoluta
dir = "$1"

case "$dir" in
	/*) ;;
	*) echo "Errore: il primo argomento deve essere una dir assoluta"
	   exit2;;
esac

if test ! -d "$dir"
then
	echo "Errore: il primo argomento deve essere una dir"
	exit 3
fi

# RICERCA
file = "$2"
PATH=$PATH:`pwd`
export PATH

#verifico se ho i permessi 
if test -x "$dir"
then
	cd "$dir"
	for i in *
	do
		if test -d "$i"
		then
			#ricorsione
			esercizio03.sh "`pwd`"/"$i" "$file"
		else
			if test -f "$i" -a "$i" = "$file"
			then
				echo trovato $i in `pwd`
			fi
		fi
	done
fi


