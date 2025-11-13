#include "registro.h"
#include <stdio.h>
#include <string.h>

void azzeraRegistro(Registro *r){
  for(int i = 0; i < DIM; i++){
    strcpy(r->studenti[i].nome, "Vuoto");
    r->studenti[i].eta = 0;
    r->studenti[i].votoMedio = 0;
  }
  r->indiceCorrente = 0;
}

void stampaRegistro(Registro r){
  if(r.indiceCorrente == 0){
    printf("Registro vuoto\n");
    printf("\n");
  }else{
    for(int i = 0; i < r.indiceCorrente; i++){
    printf("Nome: %s\n", r.studenti[i].nome);
    printf("Eta': %d\n", r.studenti[i].eta);
    printf("Voto medio: %.2f\n", r.studenti[i].votoMedio);
    printf("\n");
    }
  }
}

void aggiungiStudente(Studente s, Registro *r){
  strcpy(r->studenti[r->indiceCorrente].nome, s.nome);
  r->studenti[r->indiceCorrente].eta = s.eta;
  r->studenti[r->indiceCorrente].votoMedio = s.votoMedio;
  r->indiceCorrente++;
}