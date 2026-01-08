#include<stdlib.h>
#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<fcntl.h>
#include<sys/wait.h>
#include<time.h>
int main(int argc,char** argv){
    time_t curtime;
    time(&curtime);
    int fd,status;
    pid_t pid;
    if(argc<3){
        fprintf(stderr,"Use: ./%s <filename> <string1>...<stringn>",argv[0]);
        exit(1);
    }
    fd=open("log.txt",O_CREAT|O_TRUNC,0644);
    if(fd<0){
        perror("file");
        exit(2);
    }
    close(fd);
    for(int i=2;i<argc;i++){
        pid=fork();
        if(pid<0){
            perror("fork");
            exit(3);
        }else if(pid==0){
            char log[256];
            sprintf(log,"%s %s %s",argv[0],argv[i],ctime(&curtime));
            fd=open("log.txt",O_WRONLY|O_APPEND);
            write(fd,log,strlen(log));
            close(fd);
            printf("Numero di righe in cui compare la stringa %s\n",argv[i]);
            execlp("grep","grep","-c",argv[i],argv[1],(char*)0);
            perror("execl");
            exit(4);
        }
    }
    for(int i=2;i<argc;i++){
        wait(&status);
    }
    return 0;
}