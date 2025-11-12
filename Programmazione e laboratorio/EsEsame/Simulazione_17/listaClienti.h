#include <stdio.h>
#include <string.h>
#include <stdlib.h>
typedef struct{
    char codiceFiscale[17];
    int giorno;
    int mese;
    int anno;
    float fattura;
}File_persona;
typedef struct{
    char codiceFiscale[17];
    float totale_fatture;
    float importi_mensili[12];
}Dato_persona;
typedef struct nodo{
    Dato_persona persona;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void inizializzaLista(Lista *l);
Nodo* cercaPersona(Lista l, File_persona p);
void inserisciInTesta(Lista *l, Dato_persona p);
void inserisciOrdinato(Lista *l, File_persona p);
void stampaLista(Lista l);