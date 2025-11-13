#include "studente.h"
#include <stdio.h>

void nuovoStudente(Studente *s){
  printf("Inserisci il nome: ");
  scanf("%s", s->nome);
  printf("Inserisci l'eta': ");
  scanf("%d", &s->eta);
  printf("Inserisci il voto medio: ");
  scanf("%f", &s->votoMedio);
  printf("\n");
}