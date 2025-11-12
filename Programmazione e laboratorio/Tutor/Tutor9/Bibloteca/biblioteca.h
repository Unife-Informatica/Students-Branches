#include "libro.h"
#define DIM 10
typedef struct{
    Libro libri[DIM];
    int indice_corrente;
}Biblioteca;

void inizializza_biblioteca(Biblioteca *l);
void inserimento_biblioteca(Biblioteca *l,Libro b);
void ricerca_libro(Biblioteca l,char titolo[]);
void stampa_biblioteca(Biblioteca l);