#include <stdio.h>
#include <string.h>
#include "registro.h"
void azzeraRegistro(Registro *r){
    for (int i = 0; i < DIM; i++)
    {
        strcpy(r->studenti[i].nome,"Vuoto");
        r->studenti[i].eta=0;
        r->studenti[i].voto_medio=0;
    }
    r->indiceCorrente=0;
}
void stampaRegistro(Registro r){
    if(r.indiceCorrente == 0){
        printf("Non sono presenti studenti\n");
    }else{
        for (int i = 0; i < r.indiceCorrente; i++){
            printf("Nome: %s ",r.studenti[i].nome);
            printf("Eta: %d ",r.studenti[i].eta);
            printf("Nome: %.2f ",r.studenti[i].voto_medio);
            printf("\n");
        }
    }
}
void aggiungiStudente(Registro *r,Studente s){
    strcpy(r->studenti[r->indiceCorrente].nome,s.nome);
    r->studenti[r->indiceCorrente].eta = s.eta;
    r->studenti[r->indiceCorrente].voto_medio =s.voto_medio;
    r->indiceCorrente++;
}