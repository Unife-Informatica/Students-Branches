#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include <fcntl.h>
#include <dirent.h>
#include <unistd.h>
#include <sys/wait.h>

static volatile sig_atomic_t count = 0;

void handler_sigusr1(){}

void handler_sigint(){
  printf("Numero di richieste: %d\n", count);
  exit(0);
}

int main(int argc, char* argv[]){
  char id_utente[10], path[100], buffer[100];
  int fd, n, pid1, pid2, pid3, p1p2[2], p2p3[2], p3p0[2], n_read;

  if(argc != 2){
    printf("Errore: numero sbagliato di parametri\n");
    exit(1);
  }

  if(argv[1][0] != '/'){
    printf("Errore: <dir> deve essere un path assoluto\n");
    exit(2);
  }

  fd = opendir(argv[1]);
  if(fd == NULL){
    printf("Errore: <dir> non esiste\n");
    exit(3);
  }
  close(fd);

  signal(SIGINT, handler_sigint);

  while(1){
    printf("Inserire id utente: ");
    scanf("%s", id_utente);

    sprintf(path, "%s/%s.txt", argv[1], id_utente);
    fd = open(path, O_RDONLY);
    if(fd < 0){
      printf("Errore: il file %s non esiste\n", path);
      continue;
    }
    close(fd);

    printf("Inserire numero di risultati da visualizzare: ");
    scanf("%d", &n);

    if(n <= 0){
      printf("Errore: %d non è un intero positivo\n", n);
      continue;
    }

    if(pipe(p1p2) < 0){
      perror("P0: pipe p1p2");
      exit(4);
    }

    pid1 = fork();
    if(pid1 < 0){
      perror("P0: fork P1");
      exit(5);
    }

    if(pid1 == 0){
      signal(SIGINT, SIG_DFL);
      signal(SIGUSR1, handler_sigusr1);

      pause();

      close(p1p2[0]);

      close(1);
      dup(p1p2[1]);
      close(p1p2[1]);

      execlp("sort", "sort", "-n", path, NULL);
      perror("P1: execlp");
      exit(6);
    }

    if(pipe(p2p3) < 0){
      perror("P=: pipe p2p3");
      exit(7);
    }

    pid2 = fork();
    if(pid2 < 0){
      perror("P0: fork P2");
      exit(8);
    }

    if(pid2 == 0){
      signal(SIGINT, SIG_DFL);

      close(p1p2[1]);
      close(p2p3[0]);

      close(0);
      dup(p1p2[0]);
      close(p1p2[0]);

      close(1);
      dup(p2p3[1]);
      close(p2p3[1]);

      execlp("grep", "grep", "NON RESTITUITO", NULL);
      perror("P2: execlp");
      exit(9);
    }

    close(p1p2[0]);
    close(p1p2[1]);

    if(pipe(p3p0 < 0)){
      perror("P0: pipe p3p0");
      exit(10);
    }

    pid3 = fork();
    if(pid3 < 0){
      perror("P0: fork P3");
      exit(11);
    }

    if(pid3 == 0){
      char n_str[10];

      signal(SIGINT, SIG_DFL);

      close(p2p3[1]);
      close(p3p0[0]);

      close(0);
      dup(p2p3[0]);
      close(p2p3[0]);

      close(1);
      dup(p3p0[1]);
      close(p3p0[1]);

      sprintf(n_str, "%d", n);
      execlp("tail", "tail", "-n", n_str, NULL);
      perror("P3: execlp");
      exit(12);
    }

    close(p2p3[0]);
    close(p2p3[1]);
    close(p3p0[1]);

    sleep(1);
    kill(pid1, SIGUSR1);

    wait(NULL);
    wait(NULL);
    wait(NULL);

    while((n_read = read(p3p0[0], buffer, 100)) > 0){
      buffer[n_read] = '\0';
      printf("%s", buffer);
    }

    close(p3p0[0]);

    count++;
  }
  return 0;
}