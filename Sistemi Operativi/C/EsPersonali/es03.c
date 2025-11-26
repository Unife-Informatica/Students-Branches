#include<stdlib.h>
#include<unistd.h>
#include<signal.h>
#include<stdio.h>

int contatore=0;
void nome_gestore(int sig){
    contatore++;
    printf("Ricevuto SIGINT! (Ctrl + C) N: %d\n",contatore);
}
int main(int argc, char **argv){
    struct sigaction sa;
    sigemptyset(&sa.sa_mask);
    sa.sa_flags=0;
    sa.sa_handler=nome_gestore;
    if(sigaction(SIGINT,&sa,NULL)<0){
        perror("Errore in signaction");
        exit(1);
    }
    printf("Programma in esecuzione. Premi ctrl + C ...\n");
    while(1){
        sleep(1);
    }
    return 0;
}