#include "studente.h"
#define DIM 20

typedef struct{
  Studente studenti[DIM];
  int indiceCorrente;
}Registro;

void stampaRegistro(Registro r);
void riordinaRegistro(Registro *r);