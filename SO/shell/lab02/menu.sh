#!/bin/sh
echo "Filer"
echo "1-> Stampa file"
echo "2-> Ricerca parola in file"
echo "3-> Cerca ricorrenza parole in un file"
read scelta
case $scelta in 
	1)
		echo "Inserisci il nome di un file"
		read nameFile

		if test ! -f "$nameFile"
		then 
			echo "Errore: non e' un file"
			exit 1
		fi

		cat "$nameFile"	
	;;
	2)
		echo "Inserisci il nome del file"
		read nameFile

		if test ! -f "$nameFile"
		then
			echo "Errore: non e' un file"
			exit 2
		fi

		echo "Inserisci il nome della parola da cercare"
		read ricerca

		grep "$ricerca" "$nameFile"
	;;
	*)
		echo "Operazione non valida"

	;;
esac

