#include "listaClienti.h"
char *mesi[]={"gennaio","febbraio","marzo","aprile","maggio","giugno","luglio","agosto","settembre","ottobre","novembre","dicembre"};
void inizializzaLista(Lista *pl){
    *pl = NULL;
}
Nodo* cercaPersona(Lista l, File_persona p) {
    while (l != NULL) {
        if (strcmp(l->persona.codiceFiscale, p.codiceFiscale) == 0) {
            return l;
        }
        l = l->next;
    }
    return NULL;
}
void inserisciInTesta(Lista *pl, Dato_persona p) {
    Nodo *new = malloc(sizeof(Nodo));
    if (new == NULL) {
        fprintf(stderr, "Errore di allocazione memoria\n");
        exit(1);
    }
    new->persona = p;
    new->next = *pl;
    *pl = new;
}
void inserisciOrdinato(Lista *pl,File_persona p){
    Nodo *esistente = cercaPersona(*pl,p);
    if(esistente!=NULL){
        esistente->persona.totale_fatture+=p.fattura;
        esistente->persona.importi_mensili[p.mese-1]+=p.fattura;
    }else{
        Dato_persona nuova;
        strcpy(nuova.codiceFiscale,p.codiceFiscale);
        nuova.totale_fatture = p.fattura;
        for(int i=0;i<12;i++){
            nuova.importi_mensili[i]=0.0;
        }
        while (*pl!=NULL && strcmp((*pl)->persona.codiceFiscale,p.codiceFiscale)<0){
            pl=&(*pl)->next;
        }
        
        nuova.importi_mensili[p.mese-1]=p.fattura;
        inserisciInTesta(pl,nuova);
    }
}
void stampaLista(Lista l){
    while(l!=NULL){
        printf("%s-%.4f \n",l->persona.codiceFiscale,l->persona.totale_fatture);
        for(int i=0;i<12;i++){
            printf("\t%s: %.2f\n",mesi[i],l->persona.importi_mensili[i]);
        }
        printf("\n");
        l=l->next;
    }
}