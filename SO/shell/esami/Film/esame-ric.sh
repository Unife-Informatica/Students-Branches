#!/bin/sh

genere=$1
shift
tipo=$1
shift
anno=$1
shift

cd "$anno"

counter=0

for i in *.txt
do
    if test -r "$i"
    then
        counter = `grep "$genere" "$i"| grep "$tipo" -c`

        
    fi
done