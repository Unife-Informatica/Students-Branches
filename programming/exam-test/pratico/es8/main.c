#include <stdio.h>
#include <stdlib.h>

#include "listaNazioni.h"

int main(int argc, char const *argv[])
{
    FILE *fp;
    Record r;
    Lista l;

    if(argc != 2) {
        printf("Errore! uso: %s file_testo", argv[0]);
        exit(1);
    }

    nuovaLista(&l);

    fp = fopen(argv[1], "rt");
    if(fp == NULL) {
        printf("Errore durante l'apertura di %s", argv[1]);
        exit(2);
    }

    while(fscanf(fp, "%s %s %s", r.primo, r.secondo, r.terzo) == 3){
        addItem(&l, r.primo, 1);
        addItem(&l, r.secondo, 2);
        addItem(&l, r.terzo, 3);

    }

    fclose(fp);

    printf("### OUTPUT ESERCIZIO 1 ###\n");
    stampaLista(l);

    sortList(&l);

    printf("\n### OUTPUT ESERCIZIO 2 ###\n");
    stampaLista(l);




    return 0;
}