#!/bin/sh

# Entro nella directory passata
cd "$1"

# Contatore locale per questa cartella
cnt=0

# Ciclo sui file .txt
# Uso un controllo per evitare errori se non ci sono file txt
for i in *.txt
do
    if test -f "$i"
    then
        # Controllo SCRITTURA (-w) e contenuto (head/cut)
        # Nota: Ho aggiunto le virgolette intorno al comando head per sicurezza
        if test -w "$i" -a "`head -n 1 "$i" | cut -d "," -f 3`" = "preliminare"
        then
            # Trovato! Incremento e cancello
            cnt=$((cnt+1))
            rm -f "$i"
        fi
    fi
done

# Confronto con il record globale
record_attuale=`cat /tmp/.max_counter.tmp`

if test $cnt -gt $record_attuale
then
    # Ho trovato un nuovo campione! Aggiorno i file tmp
    echo $cnt > /tmp/.max_counter.tmp
    echo `pwd` > /tmp/.max_dirname.tmp
fi

# --- PARTE RICORSIVA ---
# Cerco tutte le sottocartelle
for i in *
do
    # Se è una directory (-d) ed è attraversabile (-x)
    if test -d "$i" -a -x "$i"
    then
        # Chiamo me stesso ($0) passando il percorso ASSOLUTO
        "$0" "`pwd`/$i"
    fi
done