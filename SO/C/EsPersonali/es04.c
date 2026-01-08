#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<signal.h>
#include<stdio.h>
#include <sys/types.h>
#include<sys/wait.h>
int contatore=0;
void gestore_sigusr1(int sig){
    contatore++;
    printf("Figlio: ricevuto SIGUSR1, contatore = %d\n",contatore);
}
int main(int argc, char** argv){
    pid_t pid;
    int status;
    pid=fork();
    if(pid<0){
        perror("fork");
        exit(1);
    }
    if(pid==0){
        struct sigaction sa = {0};  // inizializza tutto a zero
        sigemptyset(&sa.sa_mask);
        sa.sa_flags = 0;
        sa.sa_handler = gestore_sigusr1;
        if(sigaction(SIGUSR1,&sa,NULL)<0){
            perror("Error sigaction");
            exit(1);
        }
        //son infinity cicle 
        while(1){
            sleep(1);
        }
    }else{
        //father
        printf("Father: PID son=%d\n",pid);
        //sent every second for 5 times
        for(int i=0;i<5;i++){
            sleep(1);
            printf("Father: sent SIGUSR1 to son\n");
            kill(pid,SIGUSR1);
        }
        //waiting son ending (brak son)
        kill(pid,SIGKILL);
        printf("Father: ending son");
    }
    return 0;
}