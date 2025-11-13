#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

typedef int Dato;

typedef struct nodo{
  Dato dato;
  struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void insTesta(Lista *l, int d){
  Nodo *aux;
  aux = malloc(sizeof(Nodo));
  if(aux == NULL){
    printf("Allocazione non riuscita\n");
    exit(100);
  }
  aux->dato = d;
  aux->next = *l; //l del main
  *l = aux;
}

void elimTesta(Lista *l){
  Nodo *aux;
  aux = *l;
  *l = (*l)->next;
  free(aux);
}

int main(){
  Lista l = NULL;
  
  insTesta(&l, 2);
  insTesta(&l, 5);

  elimTesta(&l);

  return 0;
}