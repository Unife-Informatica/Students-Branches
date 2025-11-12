#include "funzioni.h"
void iniz_lista(Lista *pl){
    *pl=NULL;
}
void ins_testa(Lista *pl,Alimento a){
    Nodo *aux=malloc(sizeof(Nodo));
    aux->dato=a;
    aux->next=*pl;
    *pl=aux;
}
void ins_ordinato(Lista *pl,Record r){
    Alimento a;
    strcpy(a.cibo,r.cibo);
    a.calorie=r.calorie;
    ins_testa(pl,a);
}
float calorie(Lista l,char cibo[31]){
    while(l!=NULL){
        if(strcmp(cibo,l->dato.cibo)==0){
            return l->dato.calorie;
        }
        l=l->next;
    }
    return 0.0;
}