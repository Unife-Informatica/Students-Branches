#!/bin/sh

cd "$1"
shift 

# Ciclo sui nomi dei file passati come argomenti
for i in $*
do
    # Controllo esistenza (-f) e lettura (-r)
    if test -f "$i" -a -r "$i"
    then
        # Uso "$STRING" (quella esportata) e metto le virgolette
        # Grep -c conta le occorrenze
        if test `grep -c "$STRING" "$i"` -ge 1
        then
            # Trovato! Salvo path assoluto
            echo `pwd`/"$i" >> /tmp/.risultati
            
            # Salvo la riga trovata (Attenzione: qui avevi scritto STRINGA)
            grep "$STRING" "$i" >> /tmp/.stringhe
            
            # Sposto il file
            mv "$i" /tmp
        fi
    fi
done

# Ricorsione nelle sottocartelle
for dir in *
do
    if test -d "$dir" -a -x "$dir"
    then
        # Passo "$0" che è il nome dello script stesso, e "$*" per i nomi dei file
        "$0" "`pwd`/$dir" $*
    fi
done