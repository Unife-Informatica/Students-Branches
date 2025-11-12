#include <stdio.h>
#include <stdlib.h>
int main(int argc,char *argv[]){
    FILE *pfo,*pfd;
    char carattere;
    if(argc!=3){
        printf("Uso %s [orig] [dest]",argv[0]);
        exit(1);
    }
    pfo=fopen(argv[1],"rt");
    if(pfo==NULL){
        printf("Errore apertura file %s in lettura",argv[1]);
    }
    pfd=fopen(argv[2],"wt");
    if(pfo==NULL){
        printf("Errore apertura file %s in scrittura",argv[2]);
    }
    while(fscanf(pfo,"%c",&carattere)==1){
        fprintf(pfd,"%c",carattere);
    }
    fclose(pfo);
    fclose(pfd);
}   