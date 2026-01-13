#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#include <sys/wait.h>

#define DIM 100
#define DIM_PATH 200
#define DIM_BUFF 256
#define HOME "/home/studente"

static volatile sig_atomic_t count = 0;

void handler(int signo){
  printf("Numero di richieste servite: %d", count);
  exit(0);
}

int main(int argc, char* argv[]){
  int fd, status, N, nRead, p1, p2, p3, p1p2[2], p2p3[2], p3p0[2];
  char spettacolo[DIM], path[DIM_PATH], buff[DIM_BUFF];

  if(argc != 2){
    fprintf("Errore: uso -> trova_spettacoli <nomeTeatro>\n");
    exit(1);
  }

  sprintf(path, "%s%s.txt", HOME, argv[1]);
  fd = open(path, O_RDONLY);
  if(fd < 0){
    fprintf("Errore: apertura file\n");
    exit(2);
  }
  close(fd);

  signal(SIGINT, handler);

  while(1){
    printf("Inserire il nome di uno spettacolo: ");
    scanf("%s", spettacolo);

    printf("Inserire il numero di spettacoli: ");
    scanf("%d", &N);

    if(N == 0){
      break;
    }else if(N < 0){
      printf("Inserire un numero <N> intero positivo\n");
      continue;
    }

    if(pipe(p1p2) < 0){
      perror("Errore: P0 pipe p1p2");
      exit(3);
    }

    p1 = fork();
    if(p1 < 0){
      perror("Errore: P0 fork() P1");
      exit(4);
    }

    if(p1 == 0){
      signal(SIGINT, SIG_DFL);

      close(p1p2[0]);

      close(1);
      dup(p1p2[1]);
      close(p1p2[1]);

      execlp("grep", "grep", spettacolo, path, (char *)0);
      perror("Errore: grep");
      exit(5);
    }

    if(pipe(p2p3) < 0){
      perror("Errore: P0 pipe p2p3");
      exit(6);
    }

    p2 = fork();
    if(p2 < 0){
      perror("Errore: P0 fork() P2");
      exit(7);
    }

    if(p2 == 0){
      signal(SIGINT, SIG_DFL);

      close(p1p2[1]);
      close(p2p3[0]);

      close(0);
      dup(p1p2[0]);
      close(p1p2[0]);

      close(1);
      dup(p2p3[1]);
      close(p2p3[1]);

      execlp("sort", "sort", "-n", (char * )0);
      perror("Errore: sort");
      exit(8);
    }

    if(pipe(p3p0) < 0){
      perror("Errore: P0 pipe p3p0");
      exit(9);
    }

    p3 = fork();
    if(p3 < 0){
      perror("Errore: P0 fork() P3");
      exit(10);
    }

    if(p3 == 0){
      char str_n[4];

      signal(SIGINT, SIG_DFL);

      close(p1p2[0]);
      close(p1p2[1]);

      close(p2p3[1]);
      close(p3p0[0]);

      close(0);
      dup(p2p3[0]);
      close(p2p3[0]);

      close(1);
      dup(p3p0[1]);
      close(p3p0[1]);

      sprintf(str_n, "%d", N);
      execlp("head", "head", "-n", str_n, (char *)0);
      perror("Errore: head");
      exit(11);
    }

    close(p1p2[0]);
    close(p1p2[0]);

    close(p2p3[0]);
    close(p2p3[1]);

    close(p3p0[1]);

    wait(&status);
    wait(&status);
    wait(&status);

    nRead = read(p3p0[0], buff, sizeof(buff) - 1);
    if(nRead < 0){
      perror("Errore: P0 read()");
      exit(12);
    }

    close(p3p0[1]);

    buff[nRead] = '\0';
    printf("%s", buff);

    count++;
  }
  printf("Numero di richieste servite: %d\n", count);
  return 0;
}