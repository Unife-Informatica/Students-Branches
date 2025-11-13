#include <stdio.h>
#include <malloc.h>

typedef int Dato;

typedef struct nodo{
  Dato dato;
  struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void insTesta(Lista *l, Dato d){
  Nodo *aux = malloc(sizeof(Nodo));
  aux->dato = d;
  aux->next = *l;
  *l = aux;
}

void insCoda(Lista *pl, Dato d){
  while(*pl != NULL){
    pl = &(*pl)->next;
  }
  insTesta(pl, d);
}

Lista arrayToList(Dato a[], int dl){
  Lista l = NULL;
  for(int i = 0; i < dl; i++){
    insCoda(&l, a[i]);
  }
  return l;
}

int main(){
  int a[3] = {2, 5, 7};
  Lista l;

  l = arrayToList(a, 3);
}