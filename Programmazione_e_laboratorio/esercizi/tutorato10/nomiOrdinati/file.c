#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "file.h"

void leggiFile(FILE *pf, Registro *r, char *argv[]){
  Studente s;
  r->indiceCorrente = 0;
  pf = fopen(argv[1], "rt");

  if(pf == NULL){
    printf("Errore apertura file %s\n", argv[1]);
    exit(1);
  }

  while(fscanf(pf, "%s %s %d", s.cognome, s.nome, &s.matricola) == 3){
   strcpy(r->studenti[r->indiceCorrente].cognome, s.cognome);
   strcpy(r->studenti[r->indiceCorrente].nome, s.nome);
   r->studenti[r->indiceCorrente].matricola = s.matricola;
   r->indiceCorrente++;
  }

  fclose(pf);
}