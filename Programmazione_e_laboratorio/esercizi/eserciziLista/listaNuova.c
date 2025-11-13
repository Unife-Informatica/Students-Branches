#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

typedef int Dato;

typedef struct nodo{
  Dato dato;
  struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void insTesta(Lista *pl, Dato d){
  Nodo *aux;
  aux = malloc(sizeof(Nodo));
  aux->dato = d;
  aux->next = *pl;
  *pl = aux; 
}

void insCoda(Lista *pl, Dato d){
  while(*pl != NULL){
    pl = &(*pl)->next;
  }
  insTesta(pl, d);
}

void elimTesta(Lista *pl){
  Nodo *aux;
  aux = *pl;
  *pl = (*pl)->next;
  free(aux);
}

void elimina(Lista *pl, Dato d){
  while(*pl != NULL && (*pl)->dato != d){
    pl = &(*pl)->next;
  }
  if(*pl != NULL && (*pl)->dato == d){
    elimTesta(pl);
  }
}

void insOrdinato(Lista *pl, Dato d){
  while(*pl != NULL && (*pl)->dato < d){
    pl = &(*pl)->next;
  }
  insTesta(pl, d);
}

void insertionSort(Lista *pl){
  Lista l2 = NULL;
  Nodo *aux = *pl;
  while(aux != NULL){
    insOrdinato(&l2, aux->dato);
    aux = aux->next;
  }
  *pl = l2;
  }

int main(){
  Lista l = NULL;

  insTesta(&l, 3);
  insTesta(&l, 7);
  insCoda(&l, 5);
  insCoda(&l, 2);

  insertionSort(&l);
}