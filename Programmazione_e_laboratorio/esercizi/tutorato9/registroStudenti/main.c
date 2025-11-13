#include <stdio.h>
#include "registro.h"

int main(){
  int scelta;
  Registro r;
  Studente s;
  
  azzeraRegistro(&r);

  do{
    printf("Scegli: ");
    scanf("%d", &scelta);
    printf("1 - Visualizza studenti\n");
    printf("2 - Inserisci studente\n");
    printf("0 - Esci dal programma\n");
    printf("\n");
    switch(scelta){
    case 1:
      stampaRegistro(r);
      break;

    case 2:
      nuovoStudente(&s);
      aggiungiStudente(s, &r);
      break;

    default:
      break;
    }
  }while(scelta != 0);
  
  return 0;
}