#include "listaCani.h"
int main(int argc,char *argv[]){
    Lista l;
    Record r;
    FILE *pb;
    inizializza(&l);
    if(argc!=2){
        printf("Errore!\n./[eseguibile][vaccini.dat]\n");
        exit(1);
    }
    pb=fopen(argv[1],"rb");
    if(pb==NULL){
        printf("Errore nell'apertura del file: %s",argv[1]);
        exit(2);
    }
    while (fread(&r,sizeof(Record),1,pb)==1){
        insOrdinato(&l,r);
    }
    fclose(pb);
    ordinaListaPerVaccini(&l);
    stampaLista(l);
    
}