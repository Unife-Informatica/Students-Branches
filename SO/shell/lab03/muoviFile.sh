#!/bin/sh

if test $# -lt 4
then
	echo "Uso: ./muovifile <num> <dirSorgente> <dirDestinazione> <ext1>...<extN>"
	exit 1
fi

case $1 in 
	*[!0-9]*) echo "Uso: ./muovifile <num> <dirSorgente> <dirDestinazione> <ext1>...<extN>"
	       	  echo "Num deve essere un numero"
	  	  exit 2 ;;
esac
num=$1
shift

case $1 in
	/*) if test ! -d $1
	    then
		    echo "Uso: muoviFile num dirSorgente dirDestinazione ext1 ... extN"
		    echo  "$1" deve essere una directory
		    exit 3 
	    fi;;
	*) echo "Uso: ./muoviFile <num> <dirSorgente> <dirDestinazione> <ext1>...<extN>"
	   echo dirSorgente deve essere un path assoluto
	   exit 4;; 
esac

sorg=$1
shift

case $1 in
	/*) if test ! -d $1
	    then
		    echo "Uso: muovifile num dirSorgente dirDestinazione ext1 ... extN"
		    echo "$1" deve essere una directory
		    exit 5    
	    fi;;
	*) echo "Uso: muovifile num dirSorgente dirDestinazione ext1 ... extN"
           echo "dirDestinazione deve essere un Path assoluto"
	   exit 6;;
esac

dest=$1
shift

for ext in $*
do
	case $ext in 
		.*) ;;

		*) echo "Uso: muoviFile num dirSorgente dirDestinazione ext1 ... extN"
		   echo "I vari ect* devono essere delle estensioni(iniziare con '.')"
		   exit 7;;
	esac
done

# ESTENSIONE DEL PATH E CHIAMATA ALLO SCRIPT RICORSIVO
PATH=$PATH:`pwd` # aggiunge directory script corrente al PATH
export PATH # esporta il PATH

# creo un file temporaneo per salvare i risultati parziali
> /tmp/.counter.tmp

ricerca.sh "$num" "$sorg" "$dest" "$*"
echo `wc -l < /tmp/.counter.tmp`

rm -f /tmp/.counter.tmp
