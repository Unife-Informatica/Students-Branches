#!/bin/sh

std_err="Uso: ./riordina_foto.sh <dir_sorgente> <dir_destinazione>"

if test $# -ne 2
then
    echo "$std_err"
    exit 1
fi

case $1 in
    /*) echo "Errore: $1 deve essere una dir relativa"
        exit 3;;
    *)  if ! test -d "$1"
        then
            echo "$std_err"
            echo "Errore: $1 deve essere una directory"
            exit 2
        fi;;
esac

case $2 in
    /*) echo "Errore: $2 deve essere una dir relativa"
        exit 4;;
    *)  if ! test -d "$2"
        then
            echo "$std_err"
            echo "Errore: $2 deve essere una directory"
            exit 5
        fi;;
esac

#controllo che esista la cartella duplicati in dir_destinazione
if ! test -d $2/duplicati
then 
    #creo la cartella se non esiste
    mkdir $2/duplicati
fi

PATH=$PATH:`pwd`
export PATH

>/tmp/spostati

riordina_foto_aux.sh $1 `pwd`/$2
echo "Ho spostato `wc -l /tmp/spostati` file"

rm -f /tmp/spostati
