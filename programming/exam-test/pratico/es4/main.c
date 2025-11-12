#include <stdio.h>
#include <stdlib.h>

#include "listaCani.h"

int main(int argc, char const *argv[])
{
    FILE *fp;
    List l = NULL;
    Dog d;

    if (argc != 2)
    {
        fprintf(stderr, "Uso: %s file_binario\n", argv[0]);
        exit(1);
    }

    fp = fopen(argv[1], "rb");
    if (fp == NULL)
    {
        perror("Errore nell'aprire il file binario");
        exit(2);
    }

    while (fread(&d, sizeof(Dog), 1, fp) == 1)
        addItem(&l, d);

    if (fclose(fp) != 0)
    {
        perror("Errore nella chiusura del file binario");
        exit(3);
    }

    printList(l);

    sortList(&l);

    fp = fopen("vaccinati.txt", "w");
    if (fp == NULL)
    {
        perror("Errore nell'aprire il file vaccinati.txt");
        exit(4);
    }

    while (l != NULL)
    {
        if (fprintf(fp, "%d\n", l->d.chip) < 0)
        {
            fprintf(stderr, "Errore nella scrittura nel file vaccinati.txt\n");
            fclose(fp);
            exit(5);
        }
        l = l->next;
    }

    if (fclose(fp) != 0)
    {
        perror("Errore nella chiusura del file vaccinati.txt");
        exit(6);
    }

    return EXIT_SUCCESS;
}
