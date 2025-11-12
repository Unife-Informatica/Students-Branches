#!/bin/bash
#Se il numero di parametri e' not equal a 1: errore
if [ $# -ne 1 ]; 
then 
    echo "Errore: uso $0 <dir>";
    exit 1;
fi

#Creazione variabile
dir="$1"

#Se dir non e' una directory: errore
if [ ! -d "$dir" ]; 
then
    echo "Errore: $dir non e' una directory oppure non esiste";
    exit 2;
fi

#Se dir non e' una directory relativa(./): errore
#Direcotory assoluta (/)
if [ "$dir" != "./*" ];
then
    echo "Errore: $dir non e' una directory relativa";
    exit 3;
fi

#Assegna ad output un percorso e crea il file se non esiste
output="$HOME/trovato.txt"
> "$output"

#Creazione variabili
nameMaxFile=""
numMaxRighe=0

PATH=$PATH:`pwd`

export $output $nameMaxFile $numMaxRighe $PATH

./trova_file_giochi_ric "$dir"



