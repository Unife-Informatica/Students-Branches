#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "listaVeicoli.h"

void stampaLista(Lista l) {
    while(l != NULL) {
        printf("%s %d %.2f\n", l->s.targa, l->ingressi, l->price);
        l = l->next;
    }
}

int main(int argc, char const *argv[])
{
    Lista l = NULL;
    Sosta s;
    FILE *fp;
    char history[3][8];

    if (argc != 2)
    {
        printf("uso: %s file_binario");
        exit(1);
    }

    fp = fopen(argv[1], "rb");

    while(fread(&s, sizeof(Sosta), 1, fp) == 1) {
        printf("%s\n", s.targa);
        insTesta(&l, s);
        strcpy(history[2], history[1]);
        strcpy(history[1], history[0]);
        strcpy(history[0], s.targa);
    }
    
    fclose(fp);

    calcolaImporto(l);
    
    stampaLista(l);

    fp = fopen("ultimi3.txt", "w");

    for(int i = 0; i < 3; i++) {
        fprintf(fp, "%s\n", history[i]);
    }

    fclose(fp);

    return 0;
}
