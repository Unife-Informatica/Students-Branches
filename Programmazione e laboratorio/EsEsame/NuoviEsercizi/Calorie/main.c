#include "funzioni.h"
int main(int argc,char *argv[]){
    Record r;
    Lista l;
    FILE *pb,*pf;
    char cibo[31];
    int grammi;
    float calorie_totali=0;
    iniz_lista(&l);
    if(argc!=3){
        printf("Errore!\n./[eseguibile][contenuto_calorico][pasto]");
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
    if(pf==NULL){
        printf("Errore nell'apertura del file: %s",argv[2]);
        exit(3);
    }
    while(fscanf(pf,"%s %d",cibo,&grammi)==2){
        calorie_totali+=grammi*calorie(l,cibo)/100;
    }
    fclose(pf);
    printf("%.2f\n",calorie_totali);
    
    
    
}