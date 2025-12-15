#include <fcntl.h>
#include <signal.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

#define DIM 100
#define MAX_PROC 20

/*
 * Una pipe è un canale di comunicazione con due estremità (lettura[0],
 * scrittura[1]). Vengono usate per far comunicare due processi
 */

int main(int argc, char **argv) {
  pid_t pid;
  int status, N;
  char buffer[DIM];
  int pipes[MAX_PROC][2];

  if (argc != 2) {
    fprintf(stderr, "[Errore]: %s <n_figli>\n", argv[0]);
    exit(1);
  }

  for (int i = 0; i < strlen(argv[1]); i++) {
    if (argv[1][i] < '0' || argv[1][i] > '9') {
      fprintf(
          stderr,
          "[Errore]: il parametro <n_figli> deve essere un intero positivo\n");
      exit(2);
    }
  }

  N = atoi(argv[1]);
  if (N > MAX_PROC) {
    fprintf(stderr, "[Errore]: numero di processi richiesti troppo elevato\n");
    exit(3);
  }

  // Creo N pipes
  for (int i = 0; i < N; i++) {
    if (pipe(pipes[i]) == -1) {
      perror("pipe");
      exit(3);
    }
  }

  // Creo N processi figli
  for (int i = 0; i < N; i++) {
    pid = fork();

    if (pid < 0) {
      perror("Errore nella correzione della fork");
      exit(4);
    }

    if (pid == 0) {
      // chiudo la pipe nel lato lettura per il processo figlio
      close(pipes[i][0]);

      // creo il messaggio
      sprintf(buffer, "Ciao, sono il processo %d\n", getpid());
      // scrivo il messaggio nella pipe
      write(pipes[i][1], buffer, strlen(buffer) + 1);

      // chiudo la parte di lettura poi termino il figlio
      close(pipes[i][1]);
      exit(0);
    } else {
      // chiudo la scrittura del padre
      close(pipes[i][1]);
    }
  }

  for (int i = 0; i < N; i++) {
    read(pipes[i][0], buffer, DIM);
    printf("Il figlio %d dice: %s", i, buffer);

    close(pipes[i][1]);
  }

  for (int i = 0; i < N; i++) {
    wait(&status);
  }
}
