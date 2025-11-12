#define DIM 20
#include <stdio.h>
#include <string.h>
#include "studente.h"
typedef struct{
    Studente studenti[DIM];
    int indice_corrente;
}Registro;
void stampa_registro(Registro r);
void riordina_registro(Registro *r);