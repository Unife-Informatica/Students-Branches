#include "listaVeicoli.h"
void inizializza(Lista *pl){
    *pl=NULL;
}
void azzCont(Lista *pl){
    while (*pl!=NULL)
    {
        pl=&(*pl)->next;
    }
    
}
Nodo* cercaTarga(Lista l,Veicolo v){
    while (l!=NULL)
    {
        if(strcmp(l->veicolo.targa,v.targa)==0){
            return l;
        }
        l=l->next;
    }
    return NULL;
    
}
void insTesta(Lista *pl, Veicolo v) {
    Nodo *nodoEsistente = cercaTarga(*pl, v);
    if (nodoEsistente != NULL) {
        nodoEsistente->veicolo.accessi++;
        nodoEsistente->veicolo.ore += v.ore;
    } else {
        Nodo *aux = malloc(sizeof(Nodo));
        aux->veicolo = v;
        aux->veicolo.accessi = 1; // Inizializza accessi a 1
        aux->next = *pl;
        *pl = aux;
    }
}

void stampaLista(Lista l) {
    while (l != NULL) {
        printf("Targa: %s, Accessi: %d, Ore: %f\n", l->veicolo.targa, l->veicolo.accessi, l->veicolo.ore);
        l = l->next;
    }
}