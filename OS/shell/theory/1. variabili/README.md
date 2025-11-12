# 1. Variabili
I riferimenti ad una variabile si fanno con il segno `$` (`$nomevariabile`).
Si possono fare assegnamenti con:
```sh
X=2   # nella definizione di una variabile non va mai lo spazio prima e dopo l'=
nomevariabile=$nomevariabile
```

## Espressioni (`expr`)
Le variabili shell sono stringhe, ma è comunque possibile fare operazioni numeriche.
```sh
#!bin/bash

A=5
B=8
echo A=$A, B=$B

# l'operazione deve essere richiamata tra apici `` con l'istruzione expr oppure si puo usare la dicitura C=$(($A+$B))
C=`expr $A + $B`

echo C=$C
```


## Comando `eval`
Trasforma la stringa di una variabile in comando:
```sh
y=3
x='$y'
echo $x       # OUT: $y (perche x vale $y)
eval echo $x  # OUT: 3 (perche valuta $y)
```


## Comando `cut`
Seleziona parti di stringa o righe di file.
```sh
s="pippo,pluto,paperino"
echo $s | cut -c 2-9      # OUT: ippo,plu
echo $s | cut -c 2-       # OUT: ippo,pluto,paperino
echo $s | cut -f 2 -d ‘,’ # OUT: pluto
```


## Comando `tr`
Trasformazione o eliminazione di caratteri.
```sh
s="pluto,plutone"
echo $str | tr , :  # OUT: pluto:plutone
echo $str | tr -d , # OUT: plutoplutone
```