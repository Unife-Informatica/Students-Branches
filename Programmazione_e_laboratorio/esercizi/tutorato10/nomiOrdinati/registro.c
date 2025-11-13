#include "registro.h"
#include <stdio.h>
#include <string.h>

void stampaRegistro(Registro r){
  for(int i = 0; i < r.indiceCorrente; i++){
    printf("Cognome: %s\n", r.studenti[i].cognome);
    printf("Nome: %s\n", r.studenti[i].nome);
    printf("Matricola: %d\n", r.studenti[i].matricola);
    printf("\n");
  }
}

void riordinaRegistro(Registro *r){
  Studente s;
  strcpy(s.cognome, r->studenti[0].cognome);
  strcpy(s.nome, r->studenti[0].nome);
  s.matricola = r->studenti[0].matricola;
  for(int i = 0; i < r->indiceCorrente; i++){
    if(s.matricola > r->studenti[i].matricola){
      strcpy(s.cognome, r->studenti[0].cognome);
      strcpy(s.nome, r->studenti[0].nome);
      s.matricola = r->studenti[0].matricola;
    }
  }
}