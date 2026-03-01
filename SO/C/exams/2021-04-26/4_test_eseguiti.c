#include <signal.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <string.h>

#define DIM_REF 200
#define DIM_RIS 1028
#define DIM_FP 200

static volatile sig_atomic_t count = 0;
void handler(){
    printf("Numero di byte letti: %d",count);
    exit(0);
}
int main(int argc, char const *argv[]){
    int fd,status,pid,nread,nwrite,p0p1[2],p0p2[2];
    char filepath[DIM_FP], ref[DIM_REF],ris[DIM_RIS];
    //controllo numero di argomenti
    if(argc!=3){
        printf("Errore!: numero di argomenti non corretto\n");
        printf("Uso: ./test_eseguiti dir data");
        exit(1);
    }
    //controllo che dir sia una directory relativa
    //controllo che dir sia una directory
    if(argv[1][0]=='/'){
        perror("Errore!: %s deve essere una directory relativa\n",argv[1]);
        exit(2);
    }
    fd=open(argv[1],__O_DIRECTORY);
    if(fd<0){
        perror("P0: open");
        exit(3);
    }
    close(fd);
    
    //controllo che <data> sia un file
    sprintf(filepath,"%s/%s.txt",argv[1],argv[2]);
    fd=open(filepath,O_RDONLY);
    if(fd<0){
        perror("P0: open");
        exit(4);
    }

    //imposto gestione sigint handler
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

    //creazione processo P1
    pid=fork();
    if(pid<0){
        perror("P0: fork P1");
        exit(7);
    }
    if(pid==0){
        /*
        CODICE P1
        */
       //chiusura pipe
        close(p0p1[1]);
        close(p0p2[0]);

        


    }


    return 0;
}
