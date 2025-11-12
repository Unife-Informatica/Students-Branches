#include "listaUtenti.h"
void iniz_Lista(Lista *pl){
    *pl=NULL;
}
void ins_Testa(Lista *pl,Utente u){
    Nodo *aux=malloc(sizeof(Nodo));
    aux->dato=u;
    aux->next=*pl;
    *pl=aux;
}
void ins_Coda(Lista *pl,Record r){
    Utente u;
    strcpy(u.num_tel,r.num_tel);
    u.tariffa=r.tariffa;
    u.credito=r.credito;
    while(*pl!=NULL)
        pl=&(*pl)->next;
    ins_Testa(pl,u);
}
void aggiorna_Credito(Lista *pl, char num[], int sec) {
    while (*pl != NULL) {
        if (strcmp((*pl)->dato.num_tel, num) == 0) {
            switch ((*pl)->dato.tariffa) {
                case 'A': {
                    float prezzo = 0.15; // Costo alla risposta
                    prezzo += ((sec + 59) / 60) * 0.08; // Scatti anticipati ogni 60 secondi
                    (*pl)->dato.credito -= prezzo;
                    break;
                }
                case 'B': {
                    float prezzo = ((sec + 59) / 60) * 0.12; // Costo al minuto
                    (*pl)->dato.credito -= prezzo;
                    break;
                }
                default:
                    break;
            }
        }
        pl = &(*pl)->next;
    }
}
void stampa_Lista(Lista l){
    while(l!=NULL){
        printf("%s %c %.2f\n",l->dato.num_tel,l->dato.tariffa,l->dato.credito);
        l=l->next;
    }
}