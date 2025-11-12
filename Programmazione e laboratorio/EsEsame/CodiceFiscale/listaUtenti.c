#include "listaUtenti.h"
void iniz_Lista(Lista *pl){
    *pl=NULL;
}
void ins_testa(Lista *pl,Utente u){
    Nodo *aux=malloc(sizeof(Nodo));
    aux->dato=u;
    aux->next=*pl;
    *pl=aux;
}
void ins_lista(Lista *pl, Record r){
    Utente u;
    strcpy(u.cf,r.cf);
    u.att1=4;
    u.att2=4;
    u.att3=4;
    u.cont_negati=0;
    ins_testa(pl,u);
}
void controllo(Lista *pl,char txt_cf[],int corso){
    while(*pl!=NULL){
        if(strcmp((*pl)->dato.cf,txt_cf)==0){
            if(corso==1){if((*pl)->dato.att1<=0&&(*pl)->dato.cont_negati!=3){printf("CF: %s, att: 1: Acc Negato\n",(*pl)->dato.cf);(*pl)->dato.cont_negati++;}if((*pl)->dato.att1!=0)(*pl)->dato.att1--;}
            if(corso==2){if((*pl)->dato.att2<=0&&(*pl)->dato.cont_negati!=3){printf("CF: %s, att: 2: Acc Negato\n",(*pl)->dato.cf);(*pl)->dato.cont_negati++;}if((*pl)->dato.att2!=0)(*pl)->dato.att2--;}
            if(corso==3){if((*pl)->dato.att3<=0&&(*pl)->dato.cont_negati!=3){printf("CF: %s, att: 3: Acc Negato\n",(*pl)->dato.cf);(*pl)->dato.cont_negati++;}if((*pl)->dato.att3!=0)(*pl)->dato.att3--;}
        }
        pl=&(*pl)->next;
    } 
}
void print_list(Lista l){
    while(l!=NULL){
        printf("%s %d %d %d\n",l->dato.cf,l->dato.att1,l->dato.att2,l->dato.att3);
        l=l->next;
    }
}