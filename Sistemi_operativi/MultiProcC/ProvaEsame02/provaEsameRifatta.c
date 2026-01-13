#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <signal.h>
#include <sys/wait.h>

#define DIM_PATH 200
#define DIM 100

static volatile sig_atomic_t count = 0;

void handler(int signo){
  printf("Sono state servite %d richieste\n", count);
  exit(0);
}

int main(int argc, char* argv[]){
  int fd, status, p1, p2, p1p2[2];
  char video[DIM], data[9], dirPath[DIM_PATH];

  if(argc != 2){
    fprintf(stderr, "Errore: uso -> trova_video <dir>\n");
    exit(1);
  }

  if(argv[1][0] == "/"){
    fprintf("Errore: directory non relativa\n");
    exit(2);
  }

  fd = open(argv[1], __O_DIRECTORY | O_RDONLY);
  if(fd < 0){
    fprintf(stderr, "Errore apertura directory\n");
    exit(3);
  }
  close(fd);

  signal(SIGINT, handler);

  while(1){
    printf("Inserire il tipo di video: ");
    scanf("%s", video);

    printf("Inserire la data di interesse: ");
    scanf("%s", data);

    sprintf(dirPath, "%s%s.txt", argv[1], data);
    fd = open(dirPath, O_RDONLY);
    if(fd < 0){
      perror("Errore: apertura file\n");
      continue;
    }
    close(fd);

    if(pipe(p1p2) < 0){
      perror("Errore: P0 pipe p1p2");
      exit(4);
    }

    p1 = fork();
    if(p1 < 0){
      perror("Errore: P0 fork() P1");
      exit(5);
    }

    if(p1 == 0){
      signal(SIGINT, SIG_DFL);

      close(p1p2[0]);

      close(1);
      dup(p1p2[1]);
      close(p1p2[1]);

      execlp("grep", "grep", video, dirPath, (char *)0);
      perror("Errore: grep");
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

      close(0);
      dup(p1p2[0]);
      close(p1p2[0]);

      execlp("sort", "sort", "-r", "-n", (char *)0);
      perror("Errore: sort");
      exit(8);
    }

    close(p1p2[0]);
    close(p1p2[1]);
    wait(&status);
    wait(&status);

    count++;
  }
  return 0;
}