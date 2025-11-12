#include <stdio.h>
typedef struct{
    char titolo[30];
    char autore[30];
    int anno_pubblicazione;
}Libro;
void inserimento_libro(Libro *b);