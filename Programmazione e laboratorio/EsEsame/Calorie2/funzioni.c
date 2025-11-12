#include "funzioni.h"
void iniz_Lista(Lista *pl){
    *pl = NULL;
}
void ins_Testa(Lista *pl,Alimento a){
    Nodo *aux = malloc(sizeof(Nodo));
    aux->dato=a;
    aux->next = *pl;
    *pl=aux;
}
void ins_Coda(Lista *pl,Record r){
    Alimento a;
    strcpy(a.cibo,r.cibo);
    a.calorie=r.calorie;
    while (*pl!=NULL){
        pl=&(*pl)->next;
    }
    ins_Testa(pl,a); 
}
float tot_Calorie(Lista l, char cibo[]){
    while (l!=NULL){
        if(strcmp(l->dato.cibo,cibo)==0){
            return l->dato.calorie;
        }
        l=l->next;
    }
    return 0.0;
}