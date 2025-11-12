#include "file.h"
#include <stdlib.h>
#include <string.h>
void leggi_file(FILE *pf,Registro *r,char *argv[]){
    Studente s;
    r->indice_corrente=0; 
    pf=fopen(argv[1],"rt");
    if(pf==NULL){
        printf("Errore nell'apertura del file: %s",argv[1]);
        exit(1);
    }
    while (fscanf(pf,"%s %s %d",s.cognome,s.nome,&s.matricola)==3){
        strcpy(r->studenti[r->indice_corrente].cognome,s.cognome);
        strcpy(r->studenti[r->indice_corrente].nome,s.nome);
        r->studenti[r->indice_corrente].matricola = s.matricola;
        r->indice_corrente++;
    }
    fclose(pf);
}