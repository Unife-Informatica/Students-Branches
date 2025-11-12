#include "funzioni.h"
void iniz_Lista(Lista *pl){
    *pl=NULL;
}
void inserimento_testa(Lista *pl,Alimento a){
    Nodo *aux =malloc(sizeof(Nodo));
    aux->alimento=a;
    aux->next=*pl;
    *pl=aux;
}
void inserimento_coda(Lista *pl,Record r){
    Alimento a;
    strcpy(a.cibo,r.cibo);
    a.calorie=r.calorie;
    while (*pl!=NULL)
        pl=&(*pl)->next;
    inserimento_testa(pl,a);
}
float calorieTotali(Lista l,char cibo[]){
    while (l!=NULL){
        if(strcmp(l->alimento.cibo,cibo)==0){
            return l->alimento.calorie;
        }
        l=l->next;
    }
    return 0.0;
}