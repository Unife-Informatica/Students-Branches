#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
int main(int argc,char **argv){
    int fd;
    char buff[1024];
    if(argc!=2){
        fprintf(stderr,"Uso: ./%s <nomefile>\n",argv[0]);
        exit(1);
    }
    fd=open(argv[1], O_TRUNC|O_WRONLY|O_CREAT|0644);
    if(fd<0){
        perror("Error");
        exit(2);
    }
    printf("Inserisci una stringa:\n");
    fgets(buff,1024,stdin);
    while(strcmp(buff,"fine\n")!=0){
        write(fd,buff,strlen(buff));
        printf("Inserisci un altra stringa oppure(fine) per terminare\n");
        fgets(buff,1024,stdin);
    }
    close(fd);
    return 0;
}
