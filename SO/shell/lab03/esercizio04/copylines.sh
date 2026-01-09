#!/bin/sh

std_err="Uso: copylines nome_dir_assoluto stringa nome_file1...nome_fileN"

if test $# -lt 3
then
    echo "Il numero di argomenti deve essere almeno 3"
    echo "$std_err"
    exit 1
fi

if ! test -d "$1"
then 
    echo "$1 deve essere una directory"
    echo "$std_err"
    exit 2
fi

case $1 in 
    /*) ;;
    *)  echo "$1 deve essere una directory assoluta"
        echo "$std_err"
        exit 3 ;;
esac

dir="$1"; shift
STRING="$1"; shift   # Assegno a STRING

# Controllo caratteri (CORRETTO)
for par in $*
do
    case $par in
        *[!a-z]*)   echo "Errore: i nomi dei file possono contenere solo caratteri minuscoli"
                    exit 3;;
        *) ;;
    esac
done

# Aggiornamento PATH
PATH=$PATH:`pwd`
export PATH

# IMPORTANTE: Esporto STRING (quella maiuscola definita sopra)
export STRING

while true
do 
    # Resetto i file temporanei AD OGNI CICLO per sicurezza
    > /tmp/.risultati
    > /tmp/.stringhe

    # Chiamata ricorsiva
    copylines_ricorsivo.sh "$dir" $*
    
    # Conto le linee
    num_ris=`wc -l < /tmp/.risultati` # Modo più pulito di cat | wc
    
    if test $num_ris -gt 0
    then
        echo "Sono stati spostati $num_ris file"
        echo "Le righe trovate sono:"
        cat /tmp/.stringhe
        
        rm -f /tmp/.risultati /tmp/.stringhe
        exit 0
    else
        echo "Nessun file trovato. Attendo 1 ora..."
        # Sleep accetta i secondi. 60*60 = 3600
        sleep 3600    
    fi
done