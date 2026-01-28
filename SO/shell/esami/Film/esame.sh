#!/bin/sh

std_err="Uso: ./esame.sh <> <> <>"

if test $# -ne 3
then
    echo "Errore: numero di argomenti errato"
    echo "$std_err"
    exit 1;
fi

genere=$1
shift
tipo=$1
shift
anno=$1
shift

#controllo che anno sia una dir asolluta ed eseguibile
case $anno in 
    /*) if ! test -d "$anno" -a -x "$anno"
        then
            echo "$anno deve essere una direcotry"
            exit 2
        fi;;
    *)  echo "$anno deve essere una directory assoluta"
        exit 3;;
esac

#aggiorno la variabile al PATH
PATH=$PATH:`pwd`
export PATH

#creo file temporanei
export MAX_FILE=/tmp/.file.tmp
export MAX_COUNT=/tmp/.counter.tmp
echo "" > "$MAX_FILE"
echo "0" > "$MAX_COUNT"

#creo/sovrascrivo il file risultati.txt in $HOME
echo "" > $HOME/risultati

sh esame-ric.sh "$genere" "$tipo" "$anno"

if test `cat $MAX_COUNT` -gt 0
then
    cat $HOME/risultati | sort -r -n

    echo "Mese con il maggiore numero di titoli di interesse:"
    cat $MAX_FILE
    cat $MAX_COUNT
else
    echo "warning: nessun titolo di interesse trovato"
fi

