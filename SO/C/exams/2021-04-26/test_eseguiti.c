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

    pid=fork();
    if(pid<0){
        perror("P0: fork");
        exit(7);
    }
    if(pid==0){
        /*
            CODICE P1
        */

        // CHIUDO CANALI NON UTILIZZATI
        //P1 ascolta
        close(p0p1[1]);

        //P2 invia
        close(p0p2[0]);

        //imposto gestione SIGINT default
        signal(SIGINT, SIG_DFL);

        while(1){
            // leggo refertatore inviato da P0
            nread=read(p0p1[0],ref,sizeof(ref)-1);
            if(nread<0){
                perror("P1: read");
                exit(8);
            }
            ref[nread]='\0';

            pid = fork();
            if(pid<0){
                perror("P1: fork");
                exit(9);
            }
            if(pid==0){
                /*
                    CODICE P2
                */

                //chiudo pipe tra p0 e p1 lato lettura
                close(p0p1[0]);
                
                //ridirigo lo stdout
                close(1);
                dup(p0p2[1]);

                //chiudo pipe tra p0 e p2 lato scrittura
                close(p0p2[1]);

                execlp("grep","grep", ref, filepath,(char *)0);
                perror("P2: grep");
                exit(10);
            }
            //attendo terminazione P2
            wait(&status);
        }
    }

    //chiudo pipe tra p0 e p1 lato lettura
    close(p0p1[0]);

    //chiudo pipe tra p0 e p2 lato scrittura
    close(p0p2[1]);

    while(1){
        printf("Inserire refertatore: ");
        scanf("%s",ref);

        //P0 invia refertatore a P1
        nwrite = write(p0p1[1], ref, strlen(ref)+1);
        if(nwrite!=(int)(strlen(ref)+1)){
            perror("P0: write");
            exit(11);
        }

        //P0 legge e stampa i risultati inviati da P2
        nread = read(p0p2[0],res,sizeof(res)-1);
        if(nread<0){
            perror("P0: read");
            exit(12);
        }
        res[nread]='\0';
        count+=nread;
    }

    return 0;
}

