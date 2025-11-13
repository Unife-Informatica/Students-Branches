#include "listaVeicoli.h"

int main(int argc, char *argv[]){
  Lista l;
  Record r;
  FILE *pb;

  creaLista(&l);

  if(argc != 2){
    printf("Uso: ./[eseguibile] [accessi.dat]\n");
    exit(1);
  }

  pb = fopen(argv[1], "rb");
  if(pb == NULL){
    printf("Errore apertura file %s\n", argv[1]);
    exit(2);
  }

  while(fread(&r, sizeof(Record), 1, pb) == 1){
    insOrdinato(&l, r);
  }
  fclose(pb);

  calcolaPrezzo(&l);
  stampaLista(l);

  return 0;
}