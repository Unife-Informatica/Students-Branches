#!/bin/sh

std_err="Uso: ./riordina-foto <dir_sorgente> <dir_destinazione>"

if test $# -ne 2
then
    echo "$std_err"
    exit 1
fi

#controllo che dirSorg sia una directory e che sia relativa
case $1 in
    /*) echo "$1 deve essere una directory relativa"
        exit 2;;
    *)  if ! test -d "$1"
        then
            echo "$1 deve essere una directory"
            exit 3
        fi;;
esac

#controllo che dirDest sia una directory e che sia relativa
case $2 in
    /*) echo "$2 deve essere una directory relativa"
        exit 4;;
    *)  if ! test -d "$2"
        then
            echo "$2 deve essere una directory"
            exit 5
        fi;;
esac

#controllo che esista la destinazione $2/duplicati
if ! test -d "$2/duplicati"
then
    mkdir $2/duplicati
fi

>/tmp/spostati

#aggiungo pwd al path
PATH=$PATH:`pwd`
export PATH

#chiamata ricorsiva
riordina-foto-ric.sh $1 `pwd`/$2
echo "Sono stati spostati `wc -l /tmp/spostati` file"

rm -f /tmp/spostati