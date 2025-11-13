#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

typedef int Dato; //tipo del Dato int

typedef struct nodo{
  Dato valore; //valore del nodo
  struct nodo *next; //puntatatore al nodo successivo
}Nodo;

typedef Nodo *Lista; //puntatore del primo elemento della lista

void popolaLista(Lista *pl, int n){
  int numero;
  for(int i = 0; i < n; i++){
    printf("Inserisci il %d valore: ", i+1);
    scanf("%d", &numero);

    (*pl) = (Nodo*)malloc(sizeof(Nodo));
    (*pl)->valore = numero;
    (*pl)->next = NULL;
    pl = &(*pl)->next;
  }
}

int main(){
  Lista *pl;
  int n;
  
  printf("Numero di valori da inserire: ");
  scanf("%d", &n);

  popolaLista(pl, n);

  return 0;
}