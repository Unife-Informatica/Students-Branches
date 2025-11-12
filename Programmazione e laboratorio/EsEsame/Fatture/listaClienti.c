#include "listaClienti.h"
char *mesi[]={"gen","feb","mar","apr","mag","giu","lug","ago","set","ott","nov","dic"};
void iniz_lista(Lista *pl){
    *pl=NULL;
}
Nodo *ricerca_nodo(Lista l, Record r){
    while(l!=NULL){
        if(strcmp(l->dato.codice_fiscale,r.codice_fiscale)==0){
            return l;
        }
        l=l->next;
    }
    return NULL;
}   
void ins_testa(Lista *pl,Utente u){
    Nodo *aux=malloc(sizeof(Nodo));
    aux->dato=u;
    aux->next=*pl;
    *pl=aux;
}
void ins_ordinato(Lista *pl, Record r){
    Nodo *esistente = ricerca_nodo(*pl,r);
    if(esistente!=NULL){
        esistente->dato.totale_fatture+=r.importo_fattura;
        esistente->dato.importi_mensili[r.mese-1]+=r.importo_fattura;
    }else{
        Utente u;
        strcpy(u.codice_fiscale,r.codice_fiscale);
        u.totale_fatture=r.importo_fattura;
        for(int i=0;i<12;i++){
            u.importi_mensili[i]=0.0;
        }
        while(*pl!=NULL&&strcmp((*pl)->dato.codice_fiscale,r.codice_fiscale)<0){
            pl=&(*pl)->next;
        }
        u.importi_mensili[r.mese-1]=r.importo_fattura;
        ins_testa(pl,u); 
    }
}
void stampa_lista(Lista l){
    while(l!=NULL){
        printf("\t%s\n",l->dato.codice_fiscale);
        for (int i = 0; i < 12; i++){
            printf("%s: %.2f\n",mesi[i],l->dato.importi_mensili[i]);
        }
        printf("\n");
        printf("Totale: %.2f\n",l->dato.totale_fatture);
        l=l->next;
    }
}