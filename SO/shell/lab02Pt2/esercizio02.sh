#!/bin/sh
std_err="./esercizio02.sh <nomefile> <stringa1>...<stringaN>"

if ! test $# -gt 1
then
    echo "Uso: $std_err"
    exit 1
fi

if ! test -f "$1"
then
    echo "$1: deve essere un file"
    echo "Uso: $std_err"
    exit 2
fi

file=$1
shift

echo "$file: Ricerca in corso"
for i in $@
do
    counter=`grep -io "$i" "$file"|wc -l`
    echo "Parametro: $i | Ricorrenze: $counter"
done