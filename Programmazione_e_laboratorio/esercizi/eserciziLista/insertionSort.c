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

void inserimentoOrdinato(Lista *l, Dato d){
  //l è l'indirizzo della lista
  while (*l != NULL && (*l)->dato < d){
    //assegno ad l la sua coda = l = l->next
    //assegno a l l'indirizzo della coda di *l
    l = &(*l)->next;
  }
  insTesta(l, d);
}

void insertionSort(Lista *pl){
  Lista l2 = NULL;
  Nodo *p = *pl;
  while(p != NULL){
    inserimentoOrdinato(&l2, p->dato);
    p = p->next;
  }
  *pl = l2;
}

int main(){
  Lista l = NULL;
  Nodo *p;
  
  insTesta(&l, 2);
  insTesta(&l, 6);
  insTesta(&l, 1);
  insTesta(&l, 4);

  insertionSort(&l);

  return 0;
}