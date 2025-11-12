#include "listaClienti.h"
int main(int argc, char *argv[]) {
    Lista l;
    File_persona p;
    FILE *pf;
    inizializzaLista(&l);
    if(argc != 2){
        printf("Errore nei parametri\n");
        return 1;
    }
    pf = fopen(argv[1], "rb");
    if(pf == NULL){
        printf("Errore nell'apertura del file\n");
        return 2;
    }
    while (fscanf(pf, "%s %d %d %d %f", p.codiceFiscale, &p.giorno, &p.mese, &p.anno, &p.fattura) == 5){           
        inserisciOrdinato(&l, p);
    }
    fclose(pf);
    stampaLista(l);
    
    return 0;
}