#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct{
    char num_tel[11];
    char tariffa;
    float credito;
}Record;
typedef struct{
    char num_tel[11];
    char tariffa;
    float credito;
}Utente;
typedef struct nodo{
    Utente dato;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void iniz_Lista(Lista *pl);
void ins_Testa(Lista *pl,Utente u);
void ins_Coda(Lista *pl, Record r);
void aggiorna_Credito(Lista *pl, char num[], int sec);
void stampa_Lista(Lista l);


