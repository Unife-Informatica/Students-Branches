#include <stdio.h>
#include "biblioteca.h"

int main(){
  Biblioteca b;
  Libro l;
  int scelta;

  inizializzaBiblio(&b);

  do{
    printf("1 - Visualizza tutti i libri\n");
    printf("2 - Aggiungi un libro\n");
    printf("3 - Cerca un libro per titolo\n");
    printf("0 - Esci dal programma\n");
    printf("Scelta: ");
    scanf("%d", &scelta);
    printf("\n");
    switch (scelta){
    case 1:
      stampaBiblioteca(b);
      break;
    
    case 2:
      aggiungiLibro(&l);
      popolaBiblioteca(&b, l);
      break;

    case 3:
      char titolo[30];
      printf("Inserisci il titolo da cercare: ");
      scanf("%s", titolo);
      printf("\n");
      cercaLibro(b, titolo);
      break;
    
    default:
      break;
    }
  }while(scelta != 0);
  

  return 0;
}