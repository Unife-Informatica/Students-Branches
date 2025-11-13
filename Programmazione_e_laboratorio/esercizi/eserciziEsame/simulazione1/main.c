#include "listaClienti.h"

int main(int argc, char *argv[]){
  Lista l;
  Record r;
  FILE *pf;

  if(argc != 2){
    printf("Uso: ./[eseguibile] [fatture.txt]\n");
    exit(1);
  }

  pf = fopen(argv[1], "rt");
  if(pf == NULL){
    printf("Errore apertura file %s\n", argv[1]);
    exit(2);
  }

  while(fscanf(pf, "%s %d %d %d %f", r.codiceFisc, &r.giorno, &r.mese, &r.anno, &r.impFatt) == 5){
    insOrdinato(&l, r);
  }
  fclose(pf);

  stampaLista(l);

  return 0;
}