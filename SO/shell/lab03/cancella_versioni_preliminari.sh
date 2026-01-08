#!/bin/sh

# 1. Controllo argomenti
if test $# -ne 1
then
    echo "Uso: $0 <dir_assoluta>"
    exit 1
fi

# 2. Controllo directory
if ! test -d "$1"
then
    echo "Errore: $1 non e' una directory."
    exit 2
fi

# 3. Controllo path assoluto
case "$1" in
    /*) ;;
    *) echo "Errore: Devi inserire un path assoluto (che inizia con /)."
       exit 3 ;;
esac

# 4. Aggiornamento PATH (Fondamentale per trovare lo script aux)
PATH=$PATH:`pwd`
export PATH

# 5. Inizializzazione file temporanei
# Inizializzo a -1 così se trova una cartella con 0 file vince comunque e salva il percorso
echo -1 > /tmp/.max_counter.tmp
> /tmp/.max_dirname.tmp

# 6. Chiamata allo script ausiliario
cancella_versioni_preliminari_aux.sh "$1"

# 7. Stampa Risultati
max_files=`cat /tmp/.max_counter.tmp`
max_dir=`cat /tmp/.max_dirname.tmp`

if test "$max_files" -eq -1
then
    echo "Nessuna directory trovata o nessun file analizzato."
else
    echo "La directory con più file eliminati ($max_files) è: $max_dir"
fi

# 8. Pulizia
rm -f /tmp/.max_counter.tmp
rm -f /tmp/.max_dirname.tmp