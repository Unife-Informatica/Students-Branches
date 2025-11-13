#include "funzioni.h"

int main(int argc, char *argv[]){
  Lista l;
  Cibo c;
  FILE *pb, *pf;
  char nome[30];
  float grammi, totCalorie = 0;

  creaLista(&l);

  if(argc != 3){
    printf("Errore\n Uso: ./[eseguibile] [contenutoCalorico] [pasto]");
    exit(1);
  }

  pb = fopen(argv[1], "rb");
  if(pb == NULL){
    printf("Errore apertura file %s\n",argv[1]);
    exit(2);
  }

  while(fread(&c, sizeof(Cibo), 1, pb) == 1){
    insCoda(&l, c);
  }
  fclose(pb);

  pf = fopen(argv[2], "rt");
  if(pf == NULL){
    printf("Errore apertura file %s\n",argv[2]);
    exit(3);
  }

  while(fscanf(pf, "%s %f", nome, &grammi) == 2){
    totCalorie = totCalorie + calorie100(l, nome, grammi)/100.0;
  }
  fclose(pf);

  printf("Calorie totali: %f\n", totCalorie);
  return 0;
}