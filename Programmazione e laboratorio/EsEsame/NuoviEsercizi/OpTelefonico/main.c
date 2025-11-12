#include "listaUtenti.h"
int main(int argc, char *argv[]){
    Lista l;
    Record r;
    FILE *pb,*pf,*pp;
    char numeroTel[12];
    int secChiamata;
    iniz_lista(&l);
    if(argc!=3){
        printf("Errore!\n ./[eseguibile][utenti][chiamate]\n");
        exit(1);
    }
    pb=fopen(argv[1],"rb");
    if(pb==NULL){
        printf("Errore nell'apertura del file: %s",argv[1]);
    }
    while(fread(&r,sizeof(Record),1,pb)==1){
        ins_ordinato(&l,r);
    }
    fclose(pb);
    if(argc==3){
        pf=fopen(argv[2],"rt");
        if(pf==NULL){
            printf("Errore nell' apertura del file: %s",argv[2]);
            exit(3);
        }
        while(fscanf(pf,"%s %d",numeroTel,&secChiamata)==2){
            controllo_chiamata(&l,numeroTel,secChiamata);
        }
        fclose(pf);
    }
    if(argc==4){
        pp=fopen(argv[3],"rb");
        if(pp==NULL){
            printf("Errore nell' apertura del file: %s",argv[3]);
            exit(3);
        }
        while(fread()==2){
            controllo_chiamata(&l,numeroTel,secChiamata);
        }
        fclose(pf);
    }
    stampa_lista(l);
}