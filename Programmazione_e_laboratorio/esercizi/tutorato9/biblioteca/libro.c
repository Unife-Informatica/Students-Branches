#include <stdio.h>
#include "libro.h"

void aggiungiLibro(Libro *l){
  printf("Inserisci il titolo: ");
  scanf("%s", l->titolo);
  printf("Inserisci l'autore: ");
  scanf("%s", l->autore);
  printf("Inserisci l'anno di pubblicazione: ");
  scanf("%d", &l->annoPub);
  printf("\n");
}