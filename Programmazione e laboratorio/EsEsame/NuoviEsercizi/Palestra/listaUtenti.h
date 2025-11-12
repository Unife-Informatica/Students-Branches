#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct{
    char codice_fiscale[17];
}Record;
typedef struct{
    char codice_fiscale[17];
    int attivita_1;
    int attivita_2;
    int attivita_3;
    int cont_negati;
    int blocco;
}Utente;
typedef struct nodo{
    Utente dato;
    struct nodo *next;
}Nodo;

typedef Nodo *Lista;

void iniz_lista(Lista *pl);
void ins_testa(Lista *pl, Utente u);
void ins_ordinato(Lista *pl,Record r);
void controllo_acccessi(Lista *pl,char c_fiscale[17],int attivita);
void stampa_lista(Lista l);