#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <signal.h>

#define DIM_FILEPATH 200
#define DIM_DATE 32
#define DIM_STR_N 20
#define ROOT_PATH "/var/local/ticket"

static volatile sig_atomic_t count = 0;

void handler(){
  printf("Numero di richieste servite: %d\n", count);
  exit(0);
}

int main(int argc, char* argv[]){
  int fd, n, status, gg, mm, aaaa, p1, p2, p3, p1p2[2], p2p3[2];
  char filepath[DIM_FILEPATH], date[DIM_DATE];

  if(argc != 3){
    fprintf("Errore: uso trova_biglietti <destinazione> <N>\n");
    exit(1);
  }

  n = atoi(argv[2]);
  if(n <= 0){
    fprintf("Errore: <N> deve essere un numero intero positivo\n");
    exit(2);
  }

  sprintf(filepath, "%s/%s", ROOT_PATH, argv[1]);
  fd = open(filepath, O_RDONLY);
  if(fd < 0){
    fprintf("Errore: apertura file");
    exit(3);
  }
  close(fd);

  signal(SIGINT, handler);

  while(1){
    printf("Inserire giorno, mese e anno: ");
    scanf("%d %d %d", &gg, &mm, &aaaa);

    if(gg == -1 || mm == -1 || aaaa == -1){
      break;
    }else if(gg < 0 || mm < 0 || aaaa < 0){
      printf("Errore: inserire interi positivi\n");
      continue;
    }else if(gg < 1 || gg > 31){
      printf("Errore: inserire <giorno> compreso tra 0 e 31\n");
      continue;
    }else if(mm < 1 || mm > 12){
      printf("Errore: inserire <mese> compreso tra 0 e 12");
      continue;
    }

    sprintf(date, "%02d%02d%04d", gg, mm, aaaa);

    if(pipe(p1p2) < 0){
      perror("P0: pipe p1p2");
      exit(4);
    }

    p1 = fork();
    if(p1 < 0){
      perror("P0: fork() P1");
      exit(5);
    }

    if(p1 == 0){
      signal(SIGINT, SIG_DFL);

      close(p1p2[0]);

      close(1);
      dup(p1p2[1]);
      close(p1p2[1]);

      execlp("grep", "grep", date, filepath, (char *)0);
      perror("P1: grep");
      exit(6);
    }

    if(pipe(p2p3) < 0){
      perror("P0: pipe p2p3");
      exit(7);
    }

    p2 = fork();

    if(p2 < 0){
      perror("P0: fork() P2");
      exit(8);
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
      close(p2p3p[1]);

      execlp("sort", "sort", "-n", (char *)0);
      perror("P2: sort");
      exit(9);
    }

    p3 = fork();
    if(p2 < 0){
      perror("P0: fork() P3");
      exit(10);
    }

    if(p3 == 0){
      char str_n[DIM_STR_N];

      signal(SIGINT, SIG_DFL);

      close(p1p2[0]);
      close(p1p2[1]);
      close(p2p3[1]);

      close(0);
      dup(p2p3[0]);
      close(p2p3[0]);

      sprintf(str_n, "%d", n);
      execlp("head", "head", "-n", str_n, (char *)0);
      perror("P3: head");
      exit(11);
    }

    close(p1p2[0]);
    close(p1p2[1]);

    close(p2p3[0]);
    close(p2p3[1]);

    wait(&status);
    wait(&status);
    wait(&status);

    count++;
  }

  printf("Numero di richieste servite: %d\n", count);
  return 0;
}