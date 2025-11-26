#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
#include<stdio.h>
int main(int argc, char **argv){
    pid_t pid;
    pid=fork();
    if(pid<0){
        perror("fork");
        exit(1);
    }
    if(pid==0){
        printf("I'm son. PID= %d, my fhater PID = %d\n",getpid(),getppid());
    }else{
        wait(NULL);
        printf("I'm father. PID= %d, my child PID = %d\n", getpid(), pid);
    }
    return 0;

}