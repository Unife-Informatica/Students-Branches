#include <signal.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <fcntl.h>

#define DIM_FP 200
#define DIM_REF 200
#define DIM_RES 1028

static volatile sig_atomic_t count = 0;

void handler(){
    printf("Numero di byte ricevuti: %d",count);
    exit(0);
}

int main(int argc, char const *argv[]){
    int fd,pid,p0p1[2],p0p2[2],status, nread, nwrite;
    char filepath[DIM_FP],ref[DIM_REF],res[DIM_RES];

    //controllo argomenti passati
    if(argc!=3){
        printf("Errore!: Attenzione il numero di argomenti non corretti\n");
        printf("Uso: ./test_eseguiti <dir> <data>\n");
        exit(1);
    }
    //controllo che <dir> sia una directory relativa e che sia una directory
    if(argv[1][0]=='/'){
        printf("Errore!: %s deve essere una directory relativa",argv[1]);
        exit(2);
    }
    fd=open(argv[1],O_DIRECTORY);
    if(fd<0){
        perror("P0: open");
        exit(3);
    }
    close(fd);

    //controllo esistenza data
    sprintf(filepath,"%s/%s.txt",argv[1],argv[2]);
    fd=open(filepath,O_RDONLY);
    if(fd<0){
        perror("P0: open");
        exit(4);
    }
    close(fd);

    //imposto gestione SIGINT handler
    signal(SIGINT,handler);

    //creazione pipe 
    if(pipe(p0p1)<0){
        perror("P0: pipe p0p1");
        exit(5);
    }
    if(pipe(p0p2)<0){
        perror("P0: pipe p0p2");
        exit(6);
    }
    //pid p1
    pid=fork();
    if(pid<0){
        perror("P0: fork P1");
        exit(7);
    }
    if(pid==0){
        /*
        Codice P1
        P0[scrive]->P1[ascolta]da P0 e [scrive]->P2[ascolta] -> esegue ricerca e [scrive]->P0
        */

        //chiudo pipe non utilizzate
        // chiudo scrittura perche ascolta da p0
        close(p0p1[1]);

        close(p0p2[0]);

        // imposto gestione sigint
        signal(SIGINT,SIG_DFL);

        while(1){
            //leggo refertatore da p0
            nread = read(p0p1[0],ref,sizeof(ref)-1);
            if(nread<0){
                perror("P1: read");
                exit(8);
            }
            ref[nread]='\0';

            //creazione processo p2
            pid=fork();
            if(pid<0){
                perror("P1: fork P2");
                exit(9);
            }
            if(pid==0){
                /*
                Codice P2
                */
               close(p0p1[0]);
               
               //redirigo stdout
               close(1);
               dup(p0p2[1]);
               close(p0p2[1]);

               //eseguo ricerca
               exclp("grep","grep",ref,filepath,(char*)0);
               perror("P2: grep");
               exit(10);
            }
            wait(&status);
        }
        wait(&status);
        close(p0p1[0]);
        close(p0p2[1]);

        while(1){
            printf("Inserisci nome del refertatore: ");
            scanf("%s",ref);

            //p0 invia a p1 il refertatore
            nwrite = write(p0p1[1],ref,strln(ref)+1);
            if(nwrite!=(int)(strlen(ref)+1)){
                perror("P0: write");
                exit(11);
            }

            //p0 legge i risultati da p1
            nread = read(p0p2[0],res,sizof(res)-1);
            if(nread<0){
                perror("P0: read");
                exit(12);
            }
            res[nread]='\0';
            printf("%s",res);

            //incremento contatore byte
            count+=nread;
        }


    }


    return 0;
}
