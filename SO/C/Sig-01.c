#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <signal.h>
#include <stdlib.h>
#include <sys/wait.h>

volatile sig_atomic_t counter =0;
void handler_sigusr1(int sig){
    printf("the process %d has performed %d iteration for the signal %d\n",getpid(),counter,sig);
    exit(0);
}
int main(int argc, char **argv){
    pid_t *pid;
    int Nf, Nsec, status;
    if(argc!=3){
        fprintf(stderr,"Use: ./%s <num_processs> <num_sec>\n",argv[0]);
        exit(1);
    }
    Nf=atoi(argv[1]);
    if(Nf<=0){
        fprintf(stderr,"the number of process must be a positive number\n");
        exit(2);
    }
    Nsec=atoi(argv[2]);
    if(Nsec<=0){
        fprintf(stderr,"The number of second must be a positive number\n");
        exit(3);
    }
    pid=(pid_t*)malloc(Nf*sizeof(pid_t));
    for(int i=0;i<Nf;i++){
        pid[i]=fork();
        if(pid[i]<0){
            perror("fork");
            exit(4);
        }
        if(pid[i]==0){
            free(pid);
            struct sigaction sa;
            sigemptyset(&sa.sa_mask);
            sa.sa_flags=0;
            sa.sa_handler=handler_sigusr1;
            if(sigaction(SIGUSR1,&sa,NULL)<0){
                perror("sigaction");
                exit(5);
            }
            while(1){
                sleep(1);
                counter++;
            }
        }
    }
    //parent process
    sleep(Nsec);
    for(int i=0;i<Nf;i++){
        kill(pid[i],SIGUSR1);
    }
    free(pid);
    for(int i=0;i<Nf;i++){
        wait(&status);
    }
    return 0;
}