#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <malloc.h>

typedef struct{
  char codiceFisc[17];
  int giorno;
  int mese;
  int anno;
  float impFatt;
}Record;

typedef struct{
  char codiceFisc[17];
  float impTot;
  float impMese[12];
}Persona;

typedef struct nodo{
  Persona persona;
  struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void creaLista(Lista *pl);
Nodo *cercaCodiceFisc(Lista l, Record r);
void insTesta(Lista *pl, Persona p);
void insOrdinato(Lista *pl, Record r);
void stampaLista(Lista l);