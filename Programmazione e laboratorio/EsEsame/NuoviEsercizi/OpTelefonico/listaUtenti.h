#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct{
    char numero_tel[11];
    char piano_tarif;
    float credito_residuo;
}Record;
typedef struct{
    char numero_tel[11];
    char piano_tarif;
    float credito_residuo;
}Utente;
typedef struct nodo{
    Utente dato;
    struct nodo *next;
}Nodo;  
typedef Nodo *Lista;
typedef struct{
    float costo_scatto_risposta;
    int durata_scatto;
    float costo_scatto;
}PianoTariffario;
void iniz_lista(Lista *pl);
void ins_testa(Lista *pl,Utente u);
void ins_ordinato(Lista *pl, Record r);
void controllo_chiamata(Lista *pl,char numeroTel[],int secChiamata);
void stampa_lista(Lista l);

