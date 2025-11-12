#include <stdio.h>
#include <stdlib.h>

#include "listaGiornate.h"

int main(int argc, char const *argv[])
{
    FILE *fp;
    Record r;
    List l;

    if(argc != 2) {
        printf("Errore! uso: %s file_binario", argv[0]);
        exit(1);
    }

    initList(&l);

    fp = fopen(argv[1], "rb");
    if(fp == NULL) {
        printf("Errore durante l'apertura di %s", argv[1]);
        exit(2);
    }

    while(fread(&r, sizeof(Record), 1, fp) == 1) {
        update(&l, r);
    }

    fclose(fp);

    printList(l);

    return 0;
}
