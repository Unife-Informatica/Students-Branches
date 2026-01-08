#!/bin/sh

#Verifico che l'utente abbia inserito una stringa diversa da "fine"
while test "$nome" != fine
do
	#lettura pattern
	echo "Scrivi il nome del file(Inserisci 'fine' per uscire)":
	read nome

	if test "$nome" = fine
	then
		continue
	fi
	
	#ricerca pattern
	if test -f "$nome"
	then
		echo $nome e un file
	else 
		if test -d "$nome"
		then
			echo $nome e una directory
		else
			echo $nome non esiste
		fi
	fi
done
