#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <string.h>
#include <errno.h>

#define DIM 50

int main(int argc, char *argv[]){
  int pid, fd, status;
  char nome[DIM];

  if(argc != 2){
    printf("Errore: uso ./cerca <parola>\n");
    exit(1);
  }

  printf("Inserisci il nome del file di cui vuoi cercare la parola (\"fine\" per uscire): ");
  scanf("%s", nome);
  while(strcmp(nome, "fine") != 0){
    if((fd = open(nome, O_RDONLY)) < 0){
      if(errno == ENOENT){
        printf("Il file %s non esiste\n", nome);
      }else{
        perror("open");
        exit(2);
      }
    }else{
      close(fd);
      pid = fork();
      if(pid < 0){
        perror("fork");
        exit(3);
      }else if(pid == 0){
        printf("Numero di righe che contengono la parola %s: \n", argv[1]);
        execlp("grep", "grep", );
      }
    }
  }
}