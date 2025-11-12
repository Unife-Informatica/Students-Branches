#include "listaCani.h"
void inizializza(Lista *pl){
    *pl=NULL;
}
Nodo* ricerca(Lista l, Record r){
    while (l!=NULL){
        if(l->cane.chip==r.chip){
            return l;
        }
        l=l->next;
    }
    return NULL;
}
void insTesta(Lista *pl, Cane c){
    Nodo *aux = malloc(sizeof(Cane));
    aux->cane=c;
    aux->next=*pl;
    *pl=aux;
}
void insOrdinato(Lista *pl,Record r){
    Nodo *esistente = ricerca(*pl,r);
    if(esistente!=NULL){
        switch (r.vaccino){
            case 'C':
                esistente->cane.cimurro=1;
                esistente->cane.vacc_tot++;
                break;
            case 'E':
                esistente->cane.epatite=1;
                esistente->cane.vacc_tot++;
                break;
            case 'P':
                esistente->cane.parvovirosi=1;
                esistente->cane.vacc_tot++;
                break;
            default:
                break;
        }
    }else{
        Cane c;
        c.chip=r.chip;
        c.vacc_tot=0;
        c.cimurro=0;
        c.epatite=0;
        c.parvovirosi=0;
        switch (r.vaccino){
            case 'C':
                c.cimurro=1;
                c.vacc_tot++;
                break;
            case 'E':
                c.epatite=1;
                c.vacc_tot++;
                break;
            case 'P':
                c.parvovirosi=1;
                c.vacc_tot++;
                break;
            default:
                break;
        }
        while (*pl!=NULL){
            pl=&(*pl)->next;
        }
        insTesta(pl,c);
    }
}
void ordinaListaPerVaccini(Lista *pl) {
    if (*pl == NULL || (*pl)->next == NULL) return; // Lista vuota o con un solo elemento

    for (Nodo *i = *pl; i != NULL; i = i->next) {
        for (Nodo *j = i->next; j != NULL; j = j->next) {
            if (j->cane.vacc_tot > i->cane.vacc_tot) {
                Cane temp = i->cane;
                i->cane = j->cane;
                j->cane = temp;
            }
        }
    }
}

void stampaLista(Lista l) {
    FILE *pf;
    pf=fopen("vaccinati.txt","wt");
    if(pf==NULL){
        printf("Errore nell'apertura del file: vaccinati.txt");
        exit(3);
    }
    while (l!=NULL){
        fprintf(pf,"%d ",l->cane.chip);
        if(l->cane.cimurro==1){fprintf(pf,"cimurro ");}
        if(l->cane.epatite==1){ fprintf(pf,"epatite ");}
        if(l->cane.parvovirosi==1){fprintf(pf,"parvovirosi ");}
        fprintf(pf,"\n");    
        l=l->next;
    }
    fclose(pf);
}