#include "listaUtenti.h"
int main(int argc,char *argv[]){
    Lista l;
    Record r;
    FILE *pb,*pf;
    char c_fiscale[18];
    int attivita;
    iniz_lista(&l);
    if(argc!=3){
        printf("Errore!\n./[eseguibile][codicifiscali][ingressi]");
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
    pf=fopen(argv[2],"rt");
    if(pb==NULL){
        printf("Errore nell'apertura del file: %s",argv[2]);
        exit(3);
    }
    while(fscanf(pf,"%s %d",c_fiscale,&attivita)==2){
        controllo_acccessi(&l,c_fiscale,attivita);
    }
    fclose(pf);
    stampa_lista(l);
    

}