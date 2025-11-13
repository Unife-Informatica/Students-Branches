#!/bin/bash
while true; do
	echo -n "Scrivi il nome del file"
	read nome

#Se l'utente scrive "fine" termina il programma
	if [ "$nome" = "fine" ]
	then
		echo "Programma terminato"
		break
	fi
	
#Verifica se esiste un file o una directory con quel nome
	if [ -f "$nome" ]
	then
		echo "$nome è un file."
	elif [ -d "$nome" ]
		echo "$nome è una directory."
	else
		echo "$nome inesistente."
	fi
done
