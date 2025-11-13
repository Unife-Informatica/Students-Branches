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
  srand(time(NULL));
  return min+rand()%(max-min+1);
}

void popolaLista(Lista *pl){
  int a[] = {2, 3, 4, 5, 7, 8, 12, 15, 21, 24};
  for(int i = 0; i < rnd(); i++){
    (*pl) = (Nodo*)malloc(sizeof(Nodo));
    (*pl)->dato = a[i];
    (*pl)->next = NULL;
    pl = &(*pl)->next;
  }
}

int contaLista(Lista l){
  int cont = 0;
  while(l != NULL){
    cont++;
    l = l->next;
  }
  return cont;
}

void arrayLista(Lista l, int *pf){
  int i = 0;
  while(l != NULL){
    pf[i] = l->dato;
    l = l->next;
    i++;
  }
}

int main(){
  Lista l;
  int contElem;
  int *pf;

  popolaLista(&l);
  contElem = contaLista(l);

  pf = (int*)malloc(sizeof(int)*contElem);

  arrayLista(l, pf);

  for(int i = 0; i < contElem; i++){
    printf("%d - %d\n", i+1, pf[i]);
  }

  free(pf);

  return 0;
}