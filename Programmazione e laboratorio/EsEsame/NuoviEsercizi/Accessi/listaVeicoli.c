#include "listaVeicoli.h"
void iniz_lista(Lista *pl){
    *pl=NULL;
}
Nodo *ricerca_targa(Lista l,Record r){
    while(l!=NULL){
        if(strcmp(l->dato.targa,r.targa)==0){
            return l;
        }
        l=l->next;
    }
    return NULL;   
}
void ins_testa(Lista *pl,Veicolo v){
    Nodo *aux=malloc(sizeof(Nodo));
    aux->dato=v;
    aux->next=*pl;
    *pl=aux;
}
void ins_ordinato(Lista *pl,Record r){
    Nodo *esistente=ricerca_targa(*pl,r);
    if(esistente!=NULL){
        esistente->dato.accessi++;
    }else{
        Veicolo v;
        strcpy(v.targa,r.targa);
        v.accessi=1;
        ins_testa(pl,v);
    }
    
}
float calcola_prezzo(Lista l){
    if(l->dato.accessi<=5){return l->dato.accessi*2.00;}
    if(l->dato.accessi>5&&l->dato.accessi<=10){return l->dato.accessi*1.90;}
    if(l->dato.accessi>10){return l->dato.accessi*1.80;}
    return 0.0;
}
void stampa_lista(Lista l){
    while(l!=NULL){
        printf("%s %.2f\n",l->dato.targa,calcola_prezzo(l));
        l=l->next;
    }
    
}
void scrivi_lista(Lista l){
    int cont = 0;
    FILE *pf;
    pf=fopen("accessi.txt","wt");
    while(l!=NULL&&cont<3){
        fprintf(pf,"%s %.2f\n",l->dato.targa,calcola_prezzo(l));
        cont++;
        l=l->next;
    } 
    fclose(pf);
}