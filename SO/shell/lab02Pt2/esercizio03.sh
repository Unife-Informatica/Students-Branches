#!/bin/sh

std_err="./esercizio03.sh <dir_assoluta> <nomefile>"

if test $# -ne 2
then
    echo "Uso: $std_err"
    exit 1
fi

if ! test -d "$1"
then
    echo "Uso: $std_err"
    echo "$1 deve essere una directory"
    exit 2
fi
case "$1" in
    /*) ;;
    *)  echo "Uso: $std_err"
        echo "$1 deve essere una dir assoluta"
        exit 3;;
esac

dir="$1"
file="$2"

#Aggiungo al PATH percorso corrente per la ricorsione
PATH=$PATH:`pwd`
export PATH

if test -x "$dir"
then
    cd "$dir"
    for i in *
    do
        if test -d "$i"
        then
            esercizio03.sh "`pwd`/$i" "$file"
        else
            if test -f "$i" -a "$i" = "$file"
            then
                echo "File $file trovato nella dir: `pwd`"
            fi
        fi
    done
fi