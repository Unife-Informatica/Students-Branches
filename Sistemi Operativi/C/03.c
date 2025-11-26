#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <string.h>
#include <unistd.h>
int main(int argc,char** argv){
    if(argc!=2){
        fprintf(stderr,"Uso: %s <num>\n",argv[0]);
        exit(1);
    }
    int num = atoi(argv[1]);
    if(num<=0){
        fprintf(stderr,"Errore: <num> deve essere un intero positivo\n");
        exit(2);
    }
    char nomeFile[256];
    while(1){
        printf("Inserisci il nome del file(\"Fine\" per terminare):");
        scanf("%s",nomeFile);
        if(strcmp(nomeFile,"fine")==0){
            printf("Termino.\n");
            break;
        }
        if(access(nomeFile,F_OK)!=0){
            printf("Il file %s non esiste. \n",nomeFile);
            continue;
        }
        pid_t pid = fork();
        if(pid<0){
            perror("Errore");
            exit(3);
        }
        if(pid==0){
           char num_str[20];
           sprintf(num_str,"%d",num);
           execlp("head","head","-n",num_str,nomeFile,(char*)0);
           perror("exec");



           
           exit(4); 
        }
        wait(NULL);
    }
    return 0;
}