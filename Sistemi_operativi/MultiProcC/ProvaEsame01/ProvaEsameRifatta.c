#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <signal.h>
#include <sys/wait.h>

#define DIM_PATH 200
#define DIM 80
#define DIM_BUF 256

static volatile sig_atomic_t n_byte_p2 = 0;

void handler(int signo){
  printf("Byte letti dal processo P2: %d\n", n_byte_p2);
  exit(0);
}

int main(int argc, char* argv[]){
  int fd, status, p1, p2, p1p2[2], p2p0[2];
  char cognome[DIM], libro[DIM], buff[DIM_BUF], dirPath[DIM_PATH];

  if(argc != 2){
    fprintf(stderr, "Errore: uso -> controllo <dir>\n");
    exit(1);
  }

  if(argv[1][0] != "/"){
    fprintf("Errore: directory non assoluta\n");
    exit(2);
  }

  fd = open(argv[1], __O_DIRECTORY | O_RDONLY);
  if(fd < 0){
    fprintf(stderr, "Errore: apertura directory\n");
    exit(3);
  }
  close(fd);

  signal(SIGINT, handler);

  printf("Inserisci il cognome da ricercare: ");
  scanf("%s", cognome);

  printf("Inserisci il nome del libro da ricercare: ");
  scanf("%s", libro);

  while((strcmp(cognome, "fine") != 0) && (strcmp(libro, "fine") != 0)){
    if(pipe(p1p2) < 0){
      perror("Errore P0 pipe p1p2");
      exit(4);
    }

    p1 = fork();
    if(p1 < 0){
      perror("Errore P0 fork() P1");
      exit(5);
    }

    if(p1 == 0){
      signal(SIGINT, SIG_DFL);

      sprintf(dirPath, "%s%s%s.txt", argv[1], libro, cognome);
      fd = open(dirPath, O_RDONLY);
      if(fd < 0){
        perror("Errore: P1 open()");
        continue;
      }
      close(fd);

      close(p1p2[0]);

      close(1);
      dup(p1p2[1]);
      close(p1p2[1]);

      execlp("sort", "sort", dirPath, (char *)0);
      perror("Errore: P1 sort");
      exit(6);
    }

    if(pipe(p2p0) < 0){
      perror("Errore: P0 pipe p2p0");
      exit(7);
    }

    p2 = fork();
    if(p2 < 0){
      perror("Errore: P0 fork() P2");
      exit(8);
    }

    if(p2 == 0){
      signal(SIGINT, SIG_DFL);

      close(p1p2[1]);
      close(p2p0[0]);

      close(0);
      dup(p1p2[0]);
      close(p1p2[0]);

      close(1);
      dup(p2p0[1]);
      close(p2p0[1]);

      execlp("grep", "grep", "ingresso", (char *)0);
      perror("Errore: P2 grep");
      exit(9);
    }

    close(p1p2[0]);
    close(p1p2[1]);
    wait(&status);

    close(p2p0[1]);

    int byte = 0;
    memset(buff, 0, DIM_BUF);
    while((byte = read(p2p0[0], buff, sizeof(buff))) > 0){
      write(1, buff, byte);
      n_byte_p2 += byte;
      memset(buff, 0, DIM_BUF);
    }

    close(p2p0[0]);
    wait(&status);

    printf("Inserisci il cognome da ricercare: ");
    scanf("%s", cognome);

    printf("Inserisci il nome del libro da ricercare: ");
    scanf("%s", libro);
  }
  printf("Numero totale di byte letti da P2: %d\n", n_byte_p2);
  return 0;
}