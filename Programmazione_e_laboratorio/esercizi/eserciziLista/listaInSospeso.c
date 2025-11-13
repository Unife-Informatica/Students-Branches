#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

typedef int Dato;

typedef struct nodo{
  Dato valore;
  struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void popolaLista(Lista *pl, int n){
  int num;
  for(int i = 0; i < n; i++){
    printf("Inserisci il %d valore: ", i+1);
    scanf("%d", &num);

    (*pl) = (Nodo*)malloc(sizeof(Nodo));
    (*pl)->valore = num;
    (*pl)->next = NULL;
    pl = &(*pl)->next;
  }
}

void azzera(Lista *pl){
  while(*pl != NULL){
    (*pl)->valore = 0;
    (*pl) = (*pl)->next;
  }
}

int main(){
  Lista l;
  int n;

  printf("Numero di valori da inserire: ");
  scanf("%d", &n);

  popolaLista(&l, n);

  //azzera(&l);

  return 0;
}