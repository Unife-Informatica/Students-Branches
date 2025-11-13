#include <stdio.h>
#include "file.h"

int main(int argc, char *argv[]){
  FILE *pf;
  Registro r;
  int scelta;

  leggiFile(pf, &r, argv);

  do{
    printf("1 - Stampa registro\n");
    printf("2 - Inserisci in un file di testo\n");
    printf("0 - Esci dal programma\n");
    printf("Scelta: ");
    scanf("%d", &scelta);
    printf("\n");
    switch (scelta)
    {
    case 1:
      stampaRegistro(r);
      break;

    case 2:
      riordinaRegistro(&r);
      break;
    
    default:
      break;
    }
  }while(scelta != 0);
  
  
}