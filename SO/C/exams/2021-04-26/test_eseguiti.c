#include <signal.h>
#include <asm/fcntl.h>
#define DIM_REF 100
#define DIM_FP 200
#define DIM_RES 1024

#define ERR_MSG "nessun risultato trovato\n"

static volatile sig_atomic_t count = 0;

void handler(){
    printf("Numero di byte ricevuti: %d\n", count);
    exit(0);
}

int main(int argc, char const *argv[]){
    int fd, pid, p0p1[2],p0p2[2],status,nread,nwrite;
    char ref[DIM_REF],filepath[DIM_FP],res[DIM_RES];

    //Controllo che gli argomenti siano 3
    if(argc!=3){
        printf("Numero di argomenti non corretto");
        printf("Numero inserito: %d | Numero corretto: 3", argc);
    }

    //Controllo path relativa
    if(argv[1][0]=="/"){
        printf("%s deve essere una directory relativa",argv[1]);
        exit(2);
    }

    //Controllo che <dir> sia una directory
    fd=open(argv[1],O_DIRECTORY);
    if(fd<0){
        perror("%s deve essere una directory",argv[1]);
        exit(3);
    }
    close(fd);

    //Controllo che <data> esista
    sprintf(filepath,"%s/%s.txt",argv[1],argv[2]);
    fd=open(filepath,O_RDONLY);
    if(fd<0){
        perror("P0: open");
        exit(4);
    }
    close(fd);

    //imposto la gestione del segnale handler ctrl-c
    signal(SIGINT,handler);

    //creo pipe per comunicazione tra p0 e p1
    if(pipe(p0p1)<0){
        perror("P0: pipe p0p1 ");
        exit(5);
    }
    if(pipe(p0p2)<0){
        perror("P0: pipe p0p2");
        exit(6);
    }


    return 0;
}

