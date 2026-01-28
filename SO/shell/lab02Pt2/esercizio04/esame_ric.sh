#!/bin/sh

#Definizione variabili
ext="$1"
dirSorg="$2"
dirDest="$3"

cd "$dirSorg"

for i in *$ext     
do 
    if test -f "$i" -a ! -f "$dirDest/$i"
    then
        cp "$i" "$dirDest"
    fi
done

for dir in *
do
    if test -d "$dir" -a -x "$dir"
    then
        ./esame_ric.sh "$ext" `pwd`/"$dir" "$dirDest" 
    fi
done
