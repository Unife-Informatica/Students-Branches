#!/bin/sh

cd $1

counter=0
for i in *.log
do 
    #controllo di avere permessi in lettura e scrittura
    if test -r "$i" -a -w "$i"
    then
        #controllo che i contenga <header> nella prima riga
        if test `header -n 1 | grep -c "$2"` -ge 1
        then
            echo `pwd`/"$i" >> $HOME/misure.txt 

            #aggiorno il contatore
            counter=`expr $counter+1`
        fi
    fi
done

#controllo se la dir corrente e' la directory con piu file.log che contengono header
if test $counter -gt `cat /tmp/.counter.tmp`
then
    echo "$1">/tmp/.dir.tmp
    echo $counter > /tmp/.count.tmp
fi

#lancio la ricorsione
for dir in *
do
    if test -d "$dir" -a -x "$dir"
    then
        cerca_misure_ric.sh `pwd`/"$dir" $2
    fi
done