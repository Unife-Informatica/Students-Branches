#include "libro.h"
#define DIM 10

typedef struct{
  Libro libri[DIM];
  int indiceCorrente;
}Biblioteca;

void inizializzaBiblio(Biblioteca *b);
void stampaBiblioteca(Biblioteca b);
void popolaBiblioteca(Biblioteca *b, Libro l);
void cercaLibro(Biblioteca b, char titolo[]);