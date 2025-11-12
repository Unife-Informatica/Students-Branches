#include "listaClienti.h"
int main(int argc, char *argv[]){
    Record r;
    Lista l;
    FILE *pf;
    iniz_lista(&l);
    if(argc!=2){
        printf("Errore!\n./[eseguibile][fatture]");
        exit(1);
    }
    pf=fopen(argv[1],"rt");
    if(pf==NULL){
        printf("Errore nell'apertura del file: %s",argv[1]);
        exit(2);
    }
    while(fscanf(pf,"%s %d %d %d %f",r.codice_fiscale,&r.giorno,&r.mese,&r.anno,&r.importo_fattura)==5){
        ins_ordinato(&l,r);
    }
    fclose(pf);
    stampa_lista(l);
    
}