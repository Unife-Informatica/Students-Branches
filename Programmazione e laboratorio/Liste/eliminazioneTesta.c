#include <stdio.h>
#include <mm_malloc.h>
#include <time.h>
#include <stdlib.h>
typedef int Dato;
typedef struct nodo{
    Dato dato;
    struct nodo *next;
}Nodo;

typedef Nodo *Lista;
void insTesta(Lista *l, int d){
    Nodo *aux;
    aux = malloc(sizeof(Nodo));
    aux->dato=d;
    aux->next=*l; //l del main
    /*l del main*/ *l=aux;
}
void elimTesta(Lista *l){
    Nodo *aux;
    aux=*l;
    *l=(*l)->next;
    free(aux);
}
int main(){
    //l vale [](lista vuota)
    Lista l=NULL;
    //l vale [5]
    insTesta(&l,4);
    printf("%d\n",l->dato);
}