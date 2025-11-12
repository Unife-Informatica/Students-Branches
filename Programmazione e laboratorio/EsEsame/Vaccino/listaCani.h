#include <stdio.h>
#include <string.h>
#include <stdlib.h>
typedef struct{
    int chip;
    char vaccino;
}Record;
typedef struct{
    int chip;
    int cimurro;
    int epatite;
    int parvovirosi;
    int vacc_tot;
}Cane;
typedef struct nodo{
    Cane cane;
    struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void inizializza(Lista *pl);
Nodo* ricerca(Lista l,Record r);
void insTesta(Lista *pl, Cane c);
void insOrdinato(Lista *pl, Record r);
void ordinaListaPerVaccini(Lista *pl);
void stampaLista(Lista l);

