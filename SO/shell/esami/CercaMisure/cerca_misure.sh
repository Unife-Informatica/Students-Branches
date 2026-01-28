#!/bin/sh

std_err="Uso: ./cerca_misure.sh <directory> <header> "

if test $# -ne 2
then
    echo "$std_err"
    exit 1
fi

#controllo che $2 sia una directory assoluta
case $1 in 
    /*) if ! test -d "$1"
        then
            echo "$std_err"
            echo "$2 deve essere una direcotry"
            exit 2
        fi;;
    *)  echo "$2 deve essere una direcotry assoluta"
        exit 3;;
esac

#aggiorno la variabile path
PATH=$PATH:`pwd`
export PATH

#creo il file temporaneo per tenere traccia la sottodirectory che
#contine il maggior numero di file soddisfano la condizione di 
#ricerca
echo "" > /tmp/.dir.tmp
echo "0" > /tmp/.count.tmp

echo "" > $HOME/misure.txt

cerca_misure_ric.sh $1 $2

cat /tmp/.dir.tmp
cat /tmp/.counter.tmp

rm -f /tmp/.dir.tmp
rm -f /tmp/.counter.tmp