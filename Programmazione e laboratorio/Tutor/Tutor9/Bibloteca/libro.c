#include "libro.h"
void inserimento_libro(Libro *b){
    printf("Inserisci il titolo del libro:\n");
    scanf("%s",b->titolo);
    printf("Inserisci l'autore del libro:\n");
    scanf("%s",b->autore);
    printf("Inserisci l'anno di pubblicazione del libro:\n");
    scanf("%d",&b->anno_pubblicazione);
    printf("\n");
}