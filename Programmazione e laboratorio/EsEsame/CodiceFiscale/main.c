#include "listaUtenti.h"
int main(int argc, char *argv[]){
    Record r;
    Lista l;
    FILE *pb,*pf;
    char txt_cf[17];
    int corso;
    if(argc!=3){
        printf("Errore!\n./[eseguibile][utenti][ingressi]");
        exit(1);
    }
    pb=fopen(argv[1],"rb");
    if(pb==NULL){
        printf("Errore nell'apertura del file: %s",argv[1]);
        exit(2);
    }
    while(fread(&r,sizeof(Record),1,pb)==1){
        ins_lista(&l,r);
    }
    fclose(pb);
    pf=fopen(argv[2],"rt");
    if(pf==NULL){
        printf("Errore nell'apertura del file: %s",argv[2]);
        exit(3);
    }
    while(fscanf(pf,"%s %d",txt_cf,&corso)==2){
        controllo(&l,txt_cf,corso);
    }
    print_list(l);

}