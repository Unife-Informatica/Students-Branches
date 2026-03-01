#include <signal.h>
#include <bits/fcntl-linux.h>

#define DIM_FP 200
#define DIM_S 200
#define DIM_RIS 2048

#define ROOT_PATH "/home/studente"

static volatile sig_atomic_t count = 0;
void handler(){
    printf("Numeri di richieste servite: "+count);
    exit(0);
}

int main(int argc, char const *argv[]){
    
    int fd, pid, p1p2[2],p2p3[2],p0p3[2],status,nread,n;
    char filepath[DIM_FP], spettacolo[DIM_S],ris[DIM_RIS];

    //controllo argomenti passati come parametro
    if(argc!=2){
        printf("Numero di argomenti non corretto\n");
        printf("Uso: ./trova_spettacoli nomeTeatro\n");
        exit(1);
    }

    //controllo che <nome_teatro> esista
    sprintf(filepath, "%s/%s.txt",ROOT_PATH,argv[1]);
    fd=open(filepath,O_RDONLY);
    if(fd<0){
        perror("P0: open");
        exit(2);
    }
    close(fd);

    //imposto la gestione dell'handler
    signal(SIGINT,handler);

    while(1){
        printf("Inserire nome spettacolo: \n");
        scanf("%s", spettacolo);

        printf("Inserire numero di spettacoli: \n");
        scanf("%d",&n);

        //esco dal ciclo se <n> e' uguale a 0
        //ritorno un warning se e' negativo
        if(n==0)
            break;
        else if(n<0){
            printf("Warning: <n> intero negativo \n");
            continue;
        }

        //creo pipe per comunicazione tra P1 e P2
        if(pipe(p1p2)<0){
            perror("P0: pipe p1p2");
            exit(3);
        }

        pid=fork();
        if(pid<0){
            perror("P0: fork P1");
            exit(4);
        }
        if(pid==0){
            /*
            CODICE P1
            */
            //imposto gestione default di handler
            signal(SIGINT,SIG_DFL);

            close(p1p2[0]);//chiudo l'ascolto non serve

            //redirigo stdout
            close(1);
            dup(p1p2[1]);
            close(p1p2[1]);

            //seleziono gli spettacoli di interesse
            excpl("grep","grep",spettacolo,filepath,(char*)0);
            perror("P1: grep");
            exit(5);
        }

        //creo pipe tra p2 e p3
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
            CODICE P2
            */
            //imposto gestione dafault di SIGINT
            signal(SIGINT,SIG_DFL);
            
            //chiudo canali non necessarie
            close(p1p2[0]);
            close(p1p2[1]);

            //redirigo stdin
            close(0);
            dup(p1p2[0]);
            close(p1p2[0]);

            //redirigo stdout
            close(1);
            dup(p2p3[1]);
            close(p2p3[1]);

            //ordino gli spettacoli di interesse
            excpl("sort","sort","-n",(char*)0);
            perror("P2: sort");
            exit(8);
        }

        //creo pipe tra p0 e 03
        if(pipe(p0p3)<0){
            perror("P0: pipe p0p3");
            exit(9);
        }
        
        pid=fork();
        if(pid<0){
            perror("P0: fork p3");
            exit(10);
        }
        if(pid==0){
            /*
            CODICE P3
            */
            char str_n[4];
            //imposto gestione di default
            signal(SIGINT,SIG_DFL);

            //chiudo cio' che non serve 
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

            //seleziono i primi <n> file
            sprintf(str_n,"%d",n);
            excpl("head","head","-n",str_n,(char*)0);
            perror("P3: head");
            exit(11);
        }

        //chiudo pipe p1p2
        close(p1p2[0]);
        close(p1p2[1]);

        //chiudo pipe p2p3
        close(p2p3[0]);
        close(p2p3[1]);

        //chiudo pipe p0p3 
        //solo quella di scrittura
        close(p0p3[1]);

        //attendo terminazione dei processi
        wait(&status);
        wait(&status);
        wait(&status);

        //leggo i risultati
        nread=read(p0p3[0],ris,sizeof(ris)-1);
        if(nread<0){
            perror("P0: read");
            exit(12);
        }
        //chiudo pipe tra P0 e P3
        //lato lettura
        close(p0p3[0]);

        //stampo i risultati
        ris[nread] = '\0';
        printf("%s\n",ris);

        //incremento contatore richieste servite
        count++;

    }

    printf("Numero di richieste servite: %d\n",count);


    return 0;
}

