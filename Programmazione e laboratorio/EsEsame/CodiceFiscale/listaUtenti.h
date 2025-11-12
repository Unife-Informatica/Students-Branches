#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct{
    char cf[17];
}Record;
typedef struct{
    char cf[17];
    int att1;
    int att2;
    int att3;
    int cont_negati;
}Utente;
typedef struct nodo{
    Utente dato;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void iniz_lista(Lista *pl);
void ins_testa(Lista *pl,Utente u);
void ins_lista(Lista *pl, Record r);
void controllo(Lista *pl,char txt_cf[],int corso);
void print_list(Lista l);
