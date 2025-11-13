#!/bin/sh

estensione="$1"
dir1="$2"
dir2="$3"
contaFile="$4"

for f in "$dir1"/*"$estensione"
do
	if [ -f "$f" ];
	then
		base='basename "$f"'
		if [ ! -e "$dir2/$base" ];
		then
			cp "$f" "$dir2"
			echo "$base copiato in "$dir2"
			n='cat "$contaFile"'
			expr $n + 1 > "$contaFile" 2>/dev/null || echo 1 > "$contaFile"
		fi
	fi
done

for d in "$dir1"/*
do
	if [ -d "$d" ] && [ -x "$d" ];
	then
		esame_rec.sh "$estensione" "$d" "$dir2" "$contaFile"
	fi
done
