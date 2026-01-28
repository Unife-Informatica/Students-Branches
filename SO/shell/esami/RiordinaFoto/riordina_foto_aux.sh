#!/bin/sh

cd $1

#scorro tutti i file con estensione jpg
for i in *.JPG
do
    #controllo che sia un file e che io abbia i permessi di lettura
    if test -f "$i" -a -r "$i"
    then
        if test -e "$2/$i"
        then
            count=1
            while test -e "$2/duplicati/$i-$count"
            do
                count=`expr $count + 1`
            done
            mv $i "$2/duplicati/$i-$count"
        else
            mv $i "$2/$i"
            echo "$2/$i" >> /tmp/spostati
        fi
    fi
done

#chimata ricorsiva
for d in *
do
    if test -d "$d" -a -x "$d"
    then
        riordina_foto_aux.sh $d $2
    fi
done
