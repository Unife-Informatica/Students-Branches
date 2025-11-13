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

int ricerca(Lista l, Dato d){
  while(l != NULL && l->dato < d){ //criterio di ricerca non rispettato
    l = l->next;
  }
  if(l != NULL && l->dato == d){
    return 1;
  }else{
    return 0;
  }
}

int main(){
  Lista l = NULL;
  
  insTesta(&l, 2);  
  insTesta(&l, 5); // Inserimento ordinato
  insTesta(&l, 7);  

  if(ricercaOrdinata(l, 5)){
    printf("Trovato\n");
  }else{
    printf("Non trovato\n");
  }

  return 0;
}