#include "listaVeicoli.h"
int main(int argc,char *argv[]){
    Record r;
    Lista l;
    FILE *pb;
    iniz_lista(&l);
    if(argc!=2){
        printf("Errore!\n./[eseguibile][accessi]");
        exit(1);
    }
    pb=fopen(argv[1],"rb");
    if(pb==NULL){
        printf("Errore nell'apertura del file: %s",argv[1]);
        exit(2);
    }
    while(fread(&r,sizeof(Record),1,pb)==1){
        ins_ordinato(&l,r);
    }
    fclose(pb);
    stampa_lista(l);
    scrivi_lista(l);
}