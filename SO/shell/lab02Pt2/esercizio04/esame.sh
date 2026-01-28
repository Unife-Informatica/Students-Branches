#!/bin/sh

std_err="./esame.sh <estensione> <dir1> <dir2>"

if test $# -ne 3
then
    echo "Uso: $std_err"
    exit 1
fi

case $1 in
    .*) ;;
    *)  echo "Deve essere un' estensione"
        exit 2;;
esac

case $2 in
    /*) if ! test -d "$2"
        then
            echo "$2 deve essere una directory"
            exit 3
        fi;;
    *)  echo "$2 deve essere un dir assoluta"
        exit 3
esac

case $3 in
    /*) if ! test -d "$3"
        then
            echo "$3 deve essere una directory"
            exit 3
        fi;;
    *)  echo "$3 deve essere un dir assoluta"
        exit 3
esac

PATH=$PATH:`pwd`
export PATH

esame_ric.sh $1 $2 $3

