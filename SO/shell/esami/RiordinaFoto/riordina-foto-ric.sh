#!/bin/sh

cd $1

for i in *.JPG
do
    if test -f "$i" -a -r "$i"
    then
        if test -e "$2/$i"
        then
            counter=1
            while test -e "$2/duplicati/$i-$count"
            do
                count=`expr count+1`
            done
            move $i "$2/duplicati/$i-$count"
        else
            move $i "$2/$i"
            echo "$2/$i" >> /tmp/spostati
        fi;;
    fi
done

#chiamata ricorsiva
for dir in *
do
    if test -d "$dir" -a -x "$dir"
    then
        riordina-foto-ric.sh $dir $2
    fi
done