#include "studente.h"
#include <stdio.h>
void nuovoStudente(Studente *s){
    printf("Inserisci studente\n");
    printf("Inserisi nome:\n");
    scanf("%s",s->nome);
    printf("Inserisi eta:\n");
    scanf("%d",&s->eta);
    printf("Inserisi voto medio:\n");
    scanf("%f",&s->voto_medio);
}