#include "listaVeicoli.h"
int main(int argc, char *argv[]){
    Lista l;
    Veicolo v;
    FILE *pb;
    inizializza(&l);
    azzCont(&l);
    if(argc!=2){
        printf("Errore!\n./[eseguibile] [accessi.dat]\n");
        exit(1);
    }
    pb=fopen(argv[1],"rb");
    if(pb==NULL){
        printf("Errore nell'apertura del file: %s\n",argv[1]);
        exit(2);
    }
    while (fread(&v,sizeof(Veicolo),1,pb)==1){
        insTesta(&l,v);
    }
    fclose(pb);
    stampaLista(l);
}