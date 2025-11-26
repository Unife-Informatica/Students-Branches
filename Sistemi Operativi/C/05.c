#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
#include<fcntl.h>
#include<sys/wait.h>
#include<time.h>
#include<string.h>
#include<signal.h>

volatile int counter = 0;//son counter
pid_t *pid_array=NULL;//Son PID array
int Nf=0;//number of process(son)

// SIGUSR1(increment) and SIGUSR2(decrement) handler 
void heandler_son(int sig){
    if(sig==SIGUSR1){
        counter++;
    }else if(sig==SIGUSR2){
        counter--;
    }
}
//SIGINT(Ctrl+C) handler
void handler_sigint(int sig){
    printf("\n--- SIGINT recived ---\n");
    for(int i=0;i<Nf;i++){
        printf("Son PID %d: counter=%d\n",pid_array[i],counter);
    }
    //end all son
    for(int i=0;i<Nf;i++){
        kill(pid_array[i],SIGKILL);
    }
} 
int main(int argc,char **argv){
    if(argc!=2){
        fprintf(stderr,"Use: ./%s <num_process>\n",argv[1]);
        exit(1);
    }
    Nf=atoi(argv[1]);
    if(Nf<=0){
        fprintf(stderr,"The num_process must be have a positive number\n");
        exit(2);
    }
    pid_array = (pid_t*)malloc(Nf*sizeof(pid_t));
    if(!pid_array){
        perror("malloc");
        exit(3);
    }

    srand(time(NULL));
    
    //Sigint handler for a the parent process
    struct sigaction sa_int;
    sigemptyset(&sa_int.sa_mask);
    sa_int.sa_flags=0;
    sa_int.sa_handler=handler_sigint;
    if(sigaction(SIGINT,&sa_int,NULL)<0){
        perror("sigaction");
        exit(4);
    }
    // create son
    for(int i=0;i<Nf;i++){
        pid_array[i]=fork();
        if(pid_array[i]<0){
            perror("fork");
            exit(5);
        }
        if(pid_array[i]==0){
            struct sigaction sa_child;
            sigemptyset(&sa_child.sa_mask);
            sa_child.sa_flags=0;
            sa_child.sa_handler=heandler_son;
            if(sigaction(SIGUSR1,&sa_child,NULL)<0){
                perror("sigaction");
                exit(6);    
            }
            if(sigaction(SIGUSR2,&sa_child,NULL)<0){
                perror("sigaction");
                exit(7);
            }
            while(1){
                sleep(1);
            }
        }
    }
    //parent code: sent casual signal
    while(1){
        sleep(2);
        int index = rand()%Nf;
        int sig = (rand()%2==0) ? SIGUSR1:SIGUSR2;
        kill(pid_array[index],sig);
        printf("Father: sent %s at son PID %d\n",(sig==SIGUSR1)?"SIGUSR1":"SIGUSR2",pid_array[index]);
    }
    free(pid_array);
    return 0;

}
