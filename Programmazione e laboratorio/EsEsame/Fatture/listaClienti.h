#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct{
    char codice_fiscale[18];
    int giorno,mese,anno;
    float importo_fattura;
}Record;
typedef struct{
    char codice_fiscale[18];
    float importi_mensili[12];
    float totale_fatture;
}Utente;
typedef struct nodo{
    Utente dato;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void iniz_lista(Lista *pl);
Nodo *ricerca_nodo(Lista l,Record r);
void ins_testa(Lista *pl,Utente u);
void ins_ordinato(Lista *pl, Record r);
void stampa_lista(Lista l);