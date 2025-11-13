#include "studente.h"
#define DIM 5

typedef struct{
  Studente studenti[DIM];
  int indiceCorrente;
}Registro;

void azzeraRegistro(Registro *r);
void stampaRegistro(Registro r);
void aggiungiStudente(Studente s, Registro *r);