#include <stdio.h>
#include <stdlib.h>

#include "listaEsami.h"

int main(int argc, char const *argv[])
{
    FILE *fp;
    fileStudent s;
    List l;

    if(argc != 2) {
        printf("uso: %s file_binario", argv[0]);
        exit(1);
    }

    fp = fopen(argv[1], "rb");
    if(fp == NULL) {
        printf("Errore nell'apertura di %s", argv[1]);
        exit(2);
    }

    listInit(&l);

    while(fread(&s, sizeof(fileStudent), 1, fp) == 1)
        addItem(&l, s);

    printList(l);

    return 0;
}
