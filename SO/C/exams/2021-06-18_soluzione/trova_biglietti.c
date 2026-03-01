#include<stdio.h>
#include<signal.h>
#include<sys/wait.h>
#include<unistd.h>
#include<fcntl.h>

#define ROOT_PATH "/var/local/ticket"
#define DIM_FP 200
#define DIM_DATE 32
#define DIM_STR_N 20

static volatile sig_atomic_t count = 0;

void handler(){
    printf("Numero di richieste servite: %d",count);
    exit(0);
}
int main(int argc, char const *argv[]){
    int fd,pid,gg,mm,aaaa,status,p1p2[2],p2p3[2];
    char filepath[DIM_FP],date[DIM_DATE];
    //controllo numero corretto di argomenti
    if(argc!=3){
        printf("Attenzione! Numero di argomenti non corretto");
        printf("Uso: ./trova_biglietti <destinazione> <n>");
        exit(1);
    }

    //controllo che destinazione esista argv[1]
    sprintf(filepath,"%s/%s.txt",ROOT_PATH,argv[1]);
    fd=open(filepath,O_RDONLY);
    if(fd<0){
        perror("Destinazione non esistente");
        exit(2);
    }
    close(fd);

    //controllo che n sia un interno postitivo argv[2]
    if(atoi(argv[2])<=0){
        printf("errore: <n> deve essere un numero maggiore o uguale a 0\n");
        exit(3);
    }

    //imposto la gestione di SIGINT handler
    signal(SIGINT,handler);

    //richiesta giorno mese anno
    while(1){
        printf("Inserire giorno, mese, anno (GG MM AAAA):\n");
        scanf("%d %d %d", &gg, &mm, &aaaa);
        if(gg==-1||mm==-1||aaaa==-1){
            printf("Terminazione programma\n");
            break;
        }else if(gg<0||mm<0||aaaa<0){
            printf("Inserire una data valida\n");
            continue;
        }else if(gg<1||gg>31){
            printf("Errore: giorno non esistente\n");
            continue;
        }else if(mm<1||mm>12){
            printf("Errore: mese non esistente\n");
            continue;
        }

        //creazione data
        sprintf(date,"%02d%02d%04d",gg,mm,aaaa);

        //creo pipe per comunicazione p1p2
        if(pipe(p1p2)<0){
            perror("P0: pipe p1p2");
            exit(4);
        }
        //creo pipe per comunicazione p2p3
        if(pipe(p2p3)<0){
            perror("P0: pipe p2p3");
            exit(5);
        }

        pid=fork();
        if(pid<0){
            perror("P0: fork P1");
            exit(6);
        }
        if(pid==0){
            /*
            Codice P1
            */

            //imposto gestione SIGINT
            signal(SIGINT,SIG_DFL);

            //chiudo canali non utilizzati
            close(p1p2[0]);
            
            //chiudo pipe tra p2 e p3 perche' non utilizzata in p1
            close(p2p3[0]);
            close(p2p3[1]);

            //ridirigo stdout perche' p1 invia a p2
            close(1);
            dup(p1p2[1]);
            close(p1p2[1]);

            //eseguo ricerca
            execlp("grep","grep",date,filepath,(char*)0);
            perror("P1: grep");
            exit(7);

        }

        //crazione processo p2
        pid=fork();
        if(pid<0){
            perror("P0: fork p2");
            exit(8);
        }
        if(pid==0){
            /*
            Processo p2 che prende in ascolto da p1 e scrive a p3
            p1[scrive]->p2[ascolta][scrive]->p3[ascolta][stampa]
            */
           //imposto gestione SIGINT
           signal(SIGINT,SIG_DFL);
        
           //chiudo pipe non utilizzate
           /*
           Chiudo perche' p1 ha gia rediretto nello stdout e di conseguenza p2
           ascolta solo dalla pipe p1p2
           */
           close(p1p2[1]);
           /*
           Chiudo perche' p2 ascolta da p1p2[0] e invia a p3 tramite p2p3[1]
           */
           close(p2p3[0]);

           //redirigo lo stdin
           close(0);
           dup(p1p2[0]);
           close(p1p2[0]);

           //redirigo lo stdout per inviare i dati a p3
           close(1);
           dup(p2p3[1]);
           close(p2p3[1]);

           execlp("sort","sort","-n",(char*)0);
           perror("P2: sort");
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
            Ascolta da p2 e poi stampa in stdout
            */

            //imposto gestione del SIGINT
            signal(SIGINT,SIG_DFL);

            //chiudo pipe non utilizzate
            close(p1p2[0]);
            close(p1p2[1]);
            
            /*
            P3 ascolta da P2 quindi chiudo p2p3[1];
            */
           close(p2p3[1]);

           //redirigo stdin
           close(0);
           dup(p2p3[0]);
           close(p2p3[0]);

           execlp("head","head","-n",argv[2],(char*)0);
           perror("P3: head");
           exit(11);
        }
        
        //CHIUDO TUTTE LE PIPE
        close(p1p2[0]);
        close(p1p2[1]);
        close(p2p3[0]);
        close(p2p3[1]);

        //attendo terminazione processi
        wait(&status);
        wait(&status);
        wait(&status);

        count++;
    }
    
    printf("Numero di richieste servite: %d\n",count);
    return 0;
}

