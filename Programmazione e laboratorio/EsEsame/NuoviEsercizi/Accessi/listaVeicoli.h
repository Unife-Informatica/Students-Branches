#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct{
    char targa[8];
    float ore_sosta;
}Record;
typedef struct{
    char targa[8];
    float accessi;
}Veicolo;
typedef struct nodo{
    Veicolo dato;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void iniz_lista(Lista *pl);
Nodo *ricerca_targa(Lista l,Record r);
void ins_testa(Lista *pl,Veicolo v);
void ins_ordinato(Lista *pl,Record r);
float calcola_prezzo(Lista l);
void stampa_lista(Lista l);
void scrivi_lista(Lista l);
