#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <malloc.h>

typedef struct{
  char nome[31];
  float calorie;
}Cibo;

typedef struct nodo{
  Cibo cibo;
  struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void creaLista(Lista *pl);
void insTesta(Lista *pl, Cibo c);
void insCoda(Lista *pl, Cibo c);
float calorie100(Lista l, char nome[], float grammi);