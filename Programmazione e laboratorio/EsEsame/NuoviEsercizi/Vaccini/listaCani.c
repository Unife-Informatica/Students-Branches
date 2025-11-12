#include "listaCani.h"
void iniz_lista(Lista *pl){
    *pl=NULL;
}
Nodo* ricerca_cane(Lista l,Record r){
    while(l!=NULL){
        if(l->dato.chip==r.chip)
            return l;
        l=l->next;
    }
    return NULL;
}
void ins_testa(Lista *pl,Cane c){
    Nodo *aux=malloc(sizeof(Nodo));
    aux->dato=c;
    aux->next=*pl;
    *pl=aux;
}
void ins_ordinato(Lista *pl,Record r){
    Nodo *esistente=ricerca_cane(*pl,r);
    if(esistente!=NULL){
        if(r.vaccino=='C'){esistente->dato.cimurro=0;esistente->dato.tot_vacc++;}
        if(r.vaccino=='E'){esistente->dato.epatite=0;esistente->dato.tot_vacc++;}
        if(r.vaccino=='P'){esistente->dato.parvovirosi=0;esistente->dato.tot_vacc++;}
    }else{
        Cane c;
        c.tot_vacc=0;
        c.chip=r.chip;
        c.cimurro=1;
        c.epatite=1;
        c.parvovirosi=1;
        if(r.vaccino=='C'){c.cimurro=0;c.tot_vacc++;}
        if(r.vaccino=='E'){c.epatite=0;c.tot_vacc++;}
        if(r.vaccino=='P'){c.parvovirosi=0;c.tot_vacc++;}
        while(*pl!=NULL){
            pl=&(*pl)->next;
        }
        ins_testa(pl,c);
    }
}
void ordinaLista(Lista *pl){
    if(*pl==NULL||(*pl)->next==NULL) return;

    for(Nodo *i=*pl;i!=NULL;i=i->next){
        for (Nodo *j=i->next;j!=NULL;j=j->next){
            if(j->dato.tot_vacc < i->dato.tot_vacc){
                Cane temp = i->dato;
                i->dato=j->dato;
                j->dato=temp;
            }
        }
        
    }
}
void stampa_lista(Lista l){
    FILE *pf;
    pf=fopen("vaccini.txt","wt");
    if(pf==NULL){
        printf("Errore nell'apertura del file");
        exit(1);
    }
    while(l!=NULL){
        fprintf(pf,"%d ",l->dato.chip);
        if(l->dato.cimurro){fprintf(pf,"Cimurro ");}
        if(l->dato.epatite){fprintf(pf,"Epatite ");}
        if(l->dato.parvovirosi){fprintf(pf,"Parvovirosi ");}
        fprintf(pf,"\n");
        l=l->next;
    }
    
}

