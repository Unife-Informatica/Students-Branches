#include <stdio.h>
#include <stdlib.h>

#include "listaPersone.h"

int main(int argc, char const *argv[])
{
    FILE *fp;
    FileData fd;
    List l;

    if(argc != 2) {
        printf("uso: %s file_binario", argv[0]);
        exit(1);
    }

    fp = fopen(argv[1], "rb");

    initList(&l);

    while(fread(&fd, sizeof(FileData), 1, fp) == 1)
        addItem(&l, fd);

    sortList(&l);

    printList(l);


    return EXIT_SUCCESS;
}
