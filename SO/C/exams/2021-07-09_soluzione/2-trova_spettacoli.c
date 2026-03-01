#include <signal.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#define ROOT_PATH "/home/studente"
#define DIM_FP 200
#define DIM_SP 40
#define DIM_RIS 2048
static volatile sig_atomic_t count = 0;
void handler(){
    printf("Il numero di richieste servite: %d",count);
    exit(0);
}
int main(int argc, char const *argv[]){
    //dichiarazione variabili
    int pid, fd, n,p1p2[2],p2p3[2],p0p3[2],status,nread;
    char filepath[DIM_FP],spettacolo[DIM_SP],ris[DIM_RIS];
    //controllo argomenti
    if(argc!=2){
        printf("Numero di argomenti non valido\n");
        printf("Uso: ./trova_spettacoli nomeTeatro");
        exit(1);
    }

    //controllo che <nometeatro> esista
    sprintf(filepath,"%s/%s.txt",ROOT_PATH,argv[1]);
    fd = open(filepath,O_RDONLY);
    if(fd<0){
        perror("P0: open");
        exit(2);
    }
    close(fd);

    //imposto gestione handler
    signal(SIGINT,handler);

    while(1){
        printf("Inserire nome spettacolo: \n");
        scanf("%s",spettacolo);

        printf("Inserire numero spettacoli da trovare: \n");
        scanf("%d",n);

        if(n==0){
            printf("Terminazione programma");
            break;
        }else if(n<0){
            printf("Warning!: Inserire numero > 0");
            continue;
        }

        //creo pipe tra p1 e p2
        if(pipe(p1p2)<0){
            perror("P0: pipe p1p2");
            exit(3);
        }

        //creo fork per processo p1
        pid=fork();
        if(pid<0){
            perror("P0: fork P1");
            exit(4);
        }
        if(pid==0){
            /*
            Codice P1
            P1[scrive][p1p2[1]]->P2[ascolta][p1p2[0]]
            */

            //imposto gestore SIGINT
            signal(SIGINT,SIG_DFL);
           
            //chiusura canale p1p2 non utlizzato
            close(p1p2[0]);

            //redirigo stdout
            close(1);
            dup(p1p2[1]);
            close(p1p2[1]);

            //esecuzione
            execlp("grep","grep",spettacolo,filepath,(char*)0);
            perror("P1: grep");
            exit(5);

        }

        //creo pipe p2p3 perche' p2 invia a p3
        if(pipe(p2p3)<0){
            perror("P0: pipe p2p3");
            exit(6);
        }

        pid=fork();
        if(pid<0){
            perror("P0: fork P2");
            exit(7);
        }
        if(pid==0){
            /*
            Codice P2
            P2[ascolta]&[scrive]-> P3   
            */

           //imposto gestione SIGINT
           signal(SIGINT,SIG_DFL);

           //chiusura pipe non utilizzate
           close(p1p2[1]);
           close(p2p3[0]);

           //redirezione stdin
           close(0);
           dup(p1p2[0]);
           close(p1p2[0]);

           //redirezione stdout
           close(1);
           dup(p2p3[1]);
           close(p2p3[1]);

           //eseguo ricerca
           execlp("sort","sort","-n",(char*)0);
           perror("P2: sort");
           exit(8);
        }

        //creazione pipe tra p0p3
        if(pipe(p0p3)<0){
            perror("P0: pipe p0p3");
            exit(9);
        }

        //creazione processo p3
        pid=fork();
        if(pid<0){
            perror("P0: fork P3");
            exit(10);
        }
        if(pid==0){
            /*
            Codice P3
            P3[ascolta]&[scrive]->P0
            */
            char str_n[4];
            //gestione segnale SIGINT
            signal(SIGINT,SIG_DFL);

            //chiusura pipe non utilizzate
            close(p1p2[0]);
            close(p1p2[1]);
            close(p2p3[1]);
            close(p0p3[0]);

            //redirigo stdin
            close(0);
            dup(p2p3[0]);
            close(p2p3[0]);

            //redirigo stdout
            close(1);
            dup(p0p3[1]);
            close(p0p3[1]);

            //esecuzione
            sprintf(str_n,"%d",n); 
            execlp("head","head","-n",str_n,(char*)0);
            perror("P3: head");
            exit(11);
        }

        //chiudo pipe non utilizzate
        close(p1p2[0]);
        close(p1p2[1]);
        close(p2p3[1]);
        close(p2p3[0]);
        close(p0p3[1]);

        //attendo terminazione processi
        for(int i=0;i<3;i++){
            wait(&status);
        }

        //leggo da pipe
        nread=read(p0p3[0],ris,strlen(ris)-1);
        if(nread<0){
            perror("P0: read");
            exit(12);
        }

        //chiudo pipe p0p3[0]
        close(p0p3[0]);

        //stampo i risulati
        ris[nread]='\0';
        printf("%s \n",ris);

        //incremento contatore richieste servite
        count++;

    }
    printf("Numero di richieste servite: %d\n",count);
    return 0;
}
