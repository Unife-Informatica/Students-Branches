#include <signal.h>
#include <stdio.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#define DIM_FP 200
#define DIM_RF 100
#define DIM_RS 1024
static volatile sig_atomic_t count = 0;
void handler(){
    printf("Numero totale di byte ricevuti: %d ",count);
    exit(0);
}

int main(int argc, char const *argv[]){
    int fd,p0p1[2],p0p2[2],pid,nread,nwrite,status;
    char filepath[DIM_FP],ref[DIM_RF],res[DIM_RS];
    //controllo argomenti
    if(argc!=3){
        printf("Numero di argomenti non corretto\n");
        printf("Uso: ./2_test_eseguiti.c <dir> <data>\n");
        exit(1);
    }

    //controllo che <dir> sia una directory relativa
    if(argv[1][0]=='/'){
        printf("%s deve essere una directory relativa\n",argv[1]);
        exit(2);
    }

    //controllo che <dir> sia una directory
    fd=open(argv[1],O_DIRECTORY);
    if(fd<0){
        perror("P0: <dir>");
        exit(3);
    }
    close(fd);

    //controllo che <data> esista
    sprintf(filepath,"%s/%s.txt",argv[1],argv[2]);
    fd=open(filepath,O_RDONLY);
    if(fd<0){
        perror("P0: file");
        exit(4);
    }
    close(fd);

    //imposto gestione handler(ctrl-c)
    signal(SIGINT,handler);

    //creazione pipe p0p1
    if(pipe(p0p1)<0){
        perror("P0: pipe p0p1");
        exit(5);
    }

    //creazione pipe p0p2
    if(pipe(p0p2)<0){
        perror("P0: pipe p0p2");
        exit(6);
    }

    pid=fork();
    if(pid<0){
        perror("P0: fork P1");
        exit(7);
    }
    if(pid==0){
        /*
        CODICE P1        
        */

        //chiudo i canali delle pipe che non servono
        close(p0p1[1]);//chiudo canale scrittura
        close(p0p2[0]);//chiudo canale ascolto

        //imposto gestione SIGINT
        signal(SIGINT,SIG_DFL);

        while(1){
            //leggo cio' che ha inviato p1
            nread=read(p0p1[0],ref,sizeof(ref)-1);
            if(nread<0){
                perror("p1: read");
                exit(8);
            }
            ref[nread]='\0';

            pid=fork();
            if(pid<0){
                perror("P1: fork P2");
                exit(9);
            }
            if(pid==0){
                /*
                CODICE P2
                */

                //chiudo pipe non utilizzate
                close(p0p1[0]);

                //ridirigo stdout
                close(1);
                dup(p0p2[1]);
                close(p0p2[1]);

                execlp("grep","grep",ref,filepath,(char *)0);
                perror("P2: grep");
                exit(10);
            }
            //attendo terminazione p2
            wait(&status);
        }

    }
    
    //chiudo pipe tra p0 e p1 lato lettura
    close(p0p1[0]);

    //chiudo pipe tra p0 e p2 lato scrittura
    close(p0p2[1]);

    while(1){
        printf("Inserire refertatore: \n");
        scanf("%s",ref);

        //P0 invia i dati a P1
        nwrite=write(p0p1[1],ref,strlen(ref)+1);
        if(nwrite!=(int)(strlen(ref)+1)){
            perror("P0: write");
            exit(11);
        }

        //P0 legge i dati di P2;
        nread=read(p0p2[0],res,sizeof(res)-1);
        if(nread<0){
            perror("P0: read");
            exit(12);
        }
        res[nread]='\0';

        printf("%s\n",res);

        count+=nread;
    }

    return 0;
}
