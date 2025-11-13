#include "listaVeicoli.h"

void creaLista(Lista *pl){
  *pl = NULL;
}

Nodo *cercaTarga(Lista l, Record r){
  while(l != NULL){
    if(strcmp(l->veicolo.targa, r.targa) == 0){
      return l;
    }
    l = l->next;
  }
  return NULL;
}

void insTesta(Lista *pl, Veicolo v){
  Nodo *aux = malloc(sizeof(Nodo));
  aux->veicolo = v;
  aux->next = *pl;
  *pl = aux;
}

void insOrdinato(Lista *pl, Record r){
  Nodo *nodoEsistente = cercaTarga(*pl, r);
  if(nodoEsistente != NULL){
    nodoEsistente->veicolo.accessi++;
    nodoEsistente->veicolo.oreTot+=r.oreSosta;
  }else{
    Veicolo v;
    strcpy(v.targa, r.targa);
    v.oreTot = r.oreSosta;
    v.prezzoTot = 0.0;
    v.accessi = 1;
    while(*pl != NULL){
      pl = &(*pl)->next;
    }
    insTesta(pl, v);
  }
}

void calcolaPrezzo(Lista *pl){
  while(*pl != NULL){
    if((*pl)->veicolo.accessi <= 5){
      (*pl)->veicolo.prezzoTot = (*pl)->veicolo.accessi*2.0;
    }
    if((*pl)->veicolo.accessi >= 6 && (*pl)->veicolo.accessi <= 10){
      (*pl)->veicolo.prezzoTot = (*pl)->veicolo.accessi*1.90;
    }
    if((*pl)->veicolo.accessi > 10){
      (*pl)->veicolo.prezzoTot = (*pl)->veicolo.accessi*1.80;
    }
    pl = &(*pl)->next;
  }
}

void stampaLista(Lista l){
  int cont = 0;
  Nodo *aux = l;
  
  printf("LISTA COMPLETA\n");
  while(l != NULL){
    printf("%s - %.2f\n", l->veicolo.targa, l->veicolo.prezzoTot);
    cont++;
    l = l->next;
  }

  int i = 0;
  FILE *pf;

  pf = fopen("ultimi3.txt", "wt");
  if(pf == NULL){
    printf("Errore apertura file\n");
    exit(3);
  }

  while(aux != NULL){
    if(i >= cont - 3 && i <= cont){
      fprintf(pf, "%s %f\n", aux->veicolo.targa, aux->veicolo.prezzoTot);
    }
    i++;
    aux = aux->next;
  }
  fclose(pf);

  printf("\n");
}