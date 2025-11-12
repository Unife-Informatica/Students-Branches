#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct{
    char targa[8];
    float ore;
    int accessi;
}Veicolo;
typedef struct nodo{
    Veicolo veicolo;
    struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void inizializza(Lista *l);
Nodo* cercaTarga(Lista l,Veicolo v);
void insTesta(Lista *l, Veicolo v);
void azzCont(Lista *pl);
void stampaLista(Lista l);

