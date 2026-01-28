#!/bin/sh

std_err="Uso ./muoviFile.sh num dirSorg dirDest ext1 ... extN"

#Controllo argomenti
if ! test $# -ge 4
then
    echo "$std_err"
    exit 1
fi

#Controllo num
if ! test $1 -gt 0
then
    echo "$std_err"
    echo "Num deve essere > 1"
    exit 2
fi
num=$1
shift

#Controllo dirSorgente
case $1 in
    /*) if ! test -d "$1"
        then
            echo "$std_err"
            echo "dirSorg deve essere una directory"
            exit 3
        fi;;
    *)  echo "$std_err"
        echo "dirSorg deve essere una directory assoluta"
        exit 4;;
esac
dirSorg=$1
shift

#Controllo dirDestionazione
case $1 in
    /*) if ! test -d "$1"
        then
            echo "$std_err"
            echo "dirDest deve essere una directory"
            exit 5
        fi;;
    *)  echo "$std_err"
        echo "dirDest deve essere una directory assoluta"
        exit 6;;
esac
dirDest=$1
shift

