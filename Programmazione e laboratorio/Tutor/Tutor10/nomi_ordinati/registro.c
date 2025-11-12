#include "registro.h"
void stampa_registro(Registro r){
    for (int i = 0; i < r.indice_corrente; i++)
    {
        printf("Cognome: %s|Nome: %s|Matricola: %d\n",r.studenti[i].cognome,r.studenti[i].nome,r.studenti[i].matricola);
    }
    printf("\n");
}
void riordina_registro(Registro *r){
    Studente temp;
    int i=0;
    strcpy(temp.cognome,r->studenti[i].cognome);
    strcpy(temp.nome,r->studenti[i].nome);
    temp.matricola=r->studenti[i].matricola;

    for (i = 0; i < r->indice_corrente; i++)
    {
        if(temp.matricola>r->studenti[i].matricola){
            
        }
    }
    
}