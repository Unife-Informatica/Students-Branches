#!/bin/sh

if [ $# -lt 3];
then
	echo -n "Errore: uso $0 <estensione> <directory1> <directory2>"
	exit 1;
fi

estensione="$1"
dir1="$2"
dir2="$3"

case "$estensione" in
	.*) ;;
	*) echo "Errore: l'estensione deve iniziare con un punto (es: .txt); exit 2;;
esac

case "$dir1" in
	./*) ;;
	*) echo "Errore: '$dir1' non è un percorso assoluto"; exit 3;;
esac

case "$dir2" in
	./*) ;;
	*) echo "Errore: '$dir2' non è un percorso assoluto; exit 4;;
esac

if [ ! -d "$dir1" ];
then
	echo "Errore: '$dir1' non è una directory valida."
	exit 5;
fi

if [ ! -d "$dir2" ];
then
	echo "Errore: '$dir2' non è una directory valida."
	exit 6;
fi

PATH='pwd':$PATH
export PATH

> /tmp/conta_$$

esame_rec.sh "$estensione" "$dir" "$dir2" /tmp/conta_$$

echo "Numero totale di file copiati: 'cat /tmp/conta_$$'"

rm /tmp/conta_$$
