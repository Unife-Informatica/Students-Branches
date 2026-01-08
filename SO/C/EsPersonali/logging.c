#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<signal.h>
#include<sys/wait.h>

pid_t *pid;
int runnig = 1;
int Np;
int counter=0;
volatile int counter=0;
void handler_sigusr1(int sig){
    printf("[Client %d]Emergency log! Counter: %d\n",getpid(),counter);
}

void handler_sigterm(int sig){
    printf("[Client %d]Process terminated. Counter: %d\n",getpid(),counter);
    running = 0;
}

void handler_sigint(int sig){
    printf("\n[SERVER] CRTL-C ricevuto => chiudo tutti i client...\n");
    for(int i=0;i<Np;i++){
        kill(pid[i],SIGKILL);
    }
}