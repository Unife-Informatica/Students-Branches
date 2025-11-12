#include "listaUtenti.h"
int main(int argc,char *argv[]){
    Record r;
    Lista l;
    FILE *pb,*pf;
    char num[12];
    int sec;
    iniz_Lista(&l);
    if(argc!=3){
        printf("Errore!\n./[eseguibile][utenti][chiamate]");
        exit(1);
    }
    pb=fopen(argv[1],"rb");
    if(pb==NULL){
        printf("Errore nell'apertura del file: %s",argv[1]);
        exit(2);
    }
    while(fread(&r,sizeof(Record),1,pb)==1){
        ins_Coda(&l,r);
    }
    fclose(pb);
    pf=fopen(argv[2],"rt");
    if(pf==NULL){
        printf("Errore nell'apertura del file %s",argv[2]);
        exit(3);
    }
    while(fscanf(pf,"%s %d",num,&sec)==2){
        aggiorna_Credito(&l,num,sec);
    }
    stampa_Lista(l);

}