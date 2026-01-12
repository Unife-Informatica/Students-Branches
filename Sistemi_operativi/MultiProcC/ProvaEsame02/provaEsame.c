#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <wait.h>

#define DIM 100

static volatile sig_atomic_t counter = 0;

void sigint_handler(int signo){
  printf("\n CTRL-C ricevuto: \t Sono state servite %s richieste\n", counter);
  exit(0);
}

int main(int argc, char* argv[]){
  char argomento[20], data[9], to_open[DIM];
  int p1, p2, fd, status;
  int p1p2[2];
  struct sigaction s_int;

  if(argc != 2){
    sprintf(stderr, "Errore: Uso %s dir\n", argv[0]);
    exit(1);
  }

  if(argv[1][0] == '/'){
    fprintf(stderr, "Errore: dir deve essere un nome relativo di directory");
    exit(2);
  }

  fd = open(argv[1], __O_DIRECTORY);
  if(fd < 0){
    sprintf("Errore nell'apertura di dir");
    exit(3);
  }
  close(fd);

  sigemptyset(&s_int.sa_mask);
  s_int.sa_flags = 0;
  s_int.sa_handler = sigint_handler;
  sigaction(SIGINT, &s_int, NULL);

  while(1){
    printf("Inserire tipo video: \n");
    scanf("%s", argomento);

    printf("Inserire data in formato YYYYMM: \n");
    scanf("%s", data);

    sprintf(to_open, "%s/%s.txt", argv[1], data);
    fd = open(to_open, O_RDONLY);
    if(fd < 0){
      fprintf(stderr, "Errore nell'apertura del file %s\n", to_open);
      exit(4);
    }
    close(fd);

    if(pipe(p1p2) < 0){
      perror("Errore pipe() p1p2");
      exit(5);
    }

    p1 = fork();
    if(p1 < 0){
      perror("Errore: fork() P1");
      exit(6);
    }

    if(p1 == 0){
      close(p1p2[0]);

      close(1);
      dup(p1p2[1]);
      close(p1p2[1]);

      execlp("grep", "grep", argomento, to_open, (char *)0);
      perror("Errore: grep");
      exit(7);
    }

    p2 = fork();
    if(p2 < 0){
      perror("Errore: fork() P2");
      exit(8);
    }

    if(p2 == 0){
      close(p1p2[1]);

      close(0);
      dup(p1p2[0]);
      close(p1p2[0]);

      execlp("sort", "sort", "-r", "-n", (char *)0);
      perror("Errore: sort");
      exit(9);
    }

    close(p1p2[0]);
    close(p1p2[1]);
    wait(&status);
    wait(&status);
    counter++;
  }
  return 0;
}