#!bin/bash

# • Spostarsi nella propria home, visualizzare il percorso corrente e
#   creare una directory “prova_dir” all'interno della stessa.

# • Cambiarne i permessi rwx (listato, scrittura, accesso) in modo
#   che l'utente abbia pieni diritti, il gruppo non abbia la scrittura e tutti
#   gli altri non possano eseguire nessuna azione su di esso e
#   spostarsi all'interno di “prova_dir”.

# • Al suo interno, creare un file chiamato “root_list.txt” che contenga il
#   listato della directory root ( / ) e visualizzarne il contenuto.
#   Successivamente, rinominarlo con il nome “listato”.

# • A partire da “listato”, creare un secondo file "listato3" contenente
#   solamente le prime tre righe del listato di “/”. Successivamente,
#   aggiungere (append) anche le ultime tre righe del listato.

mkdir prova_dir                 # crea una directory chiamata prova_dir
ls -l                           # lista il contenuto della directory corrente
chmod u+rwx,g+wx prova_dir      # assegna tutti i permessi all'utente
chmod 750 prova_dir             # per assegnare i permessi con i numeri devo convertire i numeri in binario
cd prova_dir                    # si sposta all'interno della directory prova_dir
ls -1 / > root_list.txt         # crea un file root_list.txt con il listato della directory root
mv root_list.txt listato        # rinomina il file root_list.txt in listato
head -n 3 listato > listato3    # crea un file listato3 con le prime 3 righe di listato
tail -n 3 listato >> listato3   # aggiunge le ultime 3 righe di listato a listato3