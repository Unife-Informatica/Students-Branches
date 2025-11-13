#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <malloc.h>

typedef struct{
  char targa[8];
  float oreSosta;
}Record;

typedef struct{
  char targa[9];
  float oreTot;
  float prezzoTot;
  int accessi;
}Veicolo;

typedef struct nodo{
  Veicolo veicolo;
  struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void creaLista(Lista *pl);
Nodo *cercaTarga(Lista l, Record r);
void insTesta(Lista *pl, Veicolo v);
void insOrdinato(Lista *pl, Record r);
void calcolaPrezzo(Lista *pl);
void stampaLista(Lista l);