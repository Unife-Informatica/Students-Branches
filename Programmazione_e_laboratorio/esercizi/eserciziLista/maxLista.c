#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>

typedef int Dato;

typedef struct nodo{
  Dato dato;
  struct nodo *next;
}Nodo;

typedef Nodo *Lista;

int rnd(){
  int min = 1, max = 10;
  return min + rand()%(max-min+1);
}

void listaOrdinata(Lista *pl) {
  int a[] = {2, 3, 4, 5, 7, 8, 12, 15, 21, 24};

  for (int i = 0; i < rnd(); i++) {
    (*pl) = (Nodo*)malloc(sizeof(Nodo));
    (*pl)->dato = a[i];
    (*pl)->next = NULL;
    pl = &(*pl)->next;
  }
}

int trovaMax(Lista l){
  int max = l->dato;
  while(l != NULL){
    if(max < l->next->dato){
      max = l->next->dato;
    }
    l = l->next;
  }
  return max;
}

int main(){
  Lista l;
  int max;

  srand(time(NULL));

  listaOrdinata(&l);
  max = trovaMax(l);

  printf("Il numero massimo e': %d\n", max);

  return 0;
}
