#include "listaClienti.h"

char *mesi[] = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio",
              "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre",
              "Novembre", "Dicembre"};

void creaLista(Lista *pl){
  *pl = NULL;
}

Nodo *cercaCodiceFisc(Lista l, Record r){
  while(l != NULL){
    if(strcmp(l->persona.codiceFisc, r.codiceFisc) == 0){
      return l;
    }
    l = l->next;
  }
  return NULL;
}

void insTesta(Lista *pl, Persona p){
  Nodo *aux = malloc(sizeof(Nodo));
  aux->persona = p;
  aux->next = *pl;
  *pl = aux;
}

void insOrdinato(Lista *pl, Record r){
  Nodo *nodoEsistente = cercaCodiceFisc(*pl, r);
  if(nodoEsistente != NULL){
    nodoEsistente->persona.impTot+=r.impFatt;
    nodoEsistente->persona.impMese[r.mese-1]+=r.impFatt;
  }else{
    Persona p;
    strcpy(p.codiceFisc, r.codiceFisc);
    p.impTot = r.impFatt;
    for(int i = 0; i < 12; i++){
      p.impMese[i] = 0.0;
    }
    while(*pl != NULL && strcmp((*pl)->persona.codiceFisc, p.codiceFisc) < 0){
      pl = &(*pl)->next;
    }
    p.impMese[r.mese-1] = r.impFatt;
    insTesta(pl, p);
  }
}

void stampaLista(Lista l){
  while(l != NULL){
    printf("%s - %.2f\n", l->persona.codiceFisc, l->persona.impTot);
    for(int i = 0; i < 12; i++){
      printf("\t%s %.2f\n", mesi[i], l->persona.impMese[i]);
    }
    printf("\n");
    l = l->next;
  }
  printf("\n");
}