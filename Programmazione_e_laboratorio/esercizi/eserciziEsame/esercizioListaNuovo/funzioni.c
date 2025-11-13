#include "funzioni.h"

void creaLista(Lista *pl){
  *pl = NULL; 
}

void insTesta(Lista *pl, Cibo c){
  Nodo *aux = malloc(sizeof(Nodo));
  strcpy(aux->cibo.nome, c.nome);
  aux->cibo.calorie = c.calorie;
  aux->next = *pl;
  *pl = aux;
}

void insCoda(Lista *pl, Cibo c){
  while(*pl != NULL){
    pl = &(*pl)->next;
  }
  insTesta(pl, c);
}

float calorie100(Lista l, char nome[], float grammi){
  while(l != NULL){
    if(strcmp(l->cibo.nome, nome) == 0){
      return l->cibo.calorie*grammi;
    }
    l = l->next;
  }
}