#include "funzioni.h"
int main(int argc,char *argv[]){
    Lista l;
    Record r;
    FILE *pb, *pf;
    char cibo[31];
    float grammi, tot_calorie=0;
    iniz_Lista(&l);
    if(argc!=3){
        printf("Errore!\n ./[eseguibile] [contenutoCalorico] [pasto]\n");
        exit(1);
    }
    pb=fopen(argv[1],"rb");
    if(pb==NULL){
        printf("Errore nell'apertura del file: %s",argv[1]);
        exit(2);
    }
    while (fread(&r,sizeof(Record),1,pb)==1){
        inserimento_coda(&l,r);
    }
    fclose(pb);
    pf=fopen(argv[2],"rt");
    if(pf==NULL){
        printf("Errore nell'apertura del file: %s",argv[2]);
        exit(3);
    }
    while (fscanf(pf,"%s %f",cibo,&grammi)==2){
        tot_calorie+=grammi*calorieTotali(l,cibo)/100;
    }
    fclose(pf);
    printf("Calorie totali: %f\n",tot_calorie);
    
    
}