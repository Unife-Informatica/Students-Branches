#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct{
    int chip;
    char vaccino;
}Record;
typedef struct{
    int chip;
    int cimurro;
    int epatite;
    int parvovirosi;
    int tot_vacc;
}Cane;
typedef struct nodo{
    Cane dato;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void iniz_lista(Lista *pl);
Nodo* ricerca_cane(Lista l,Record r);
void ins_testa(Lista *pl, Cane c);
void ins_ordinato(Lista *pl, Record r);
void ordinaLista(Lista *pl);
void stampa_lista(Lista l);