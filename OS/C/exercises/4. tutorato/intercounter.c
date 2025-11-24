#include <fcntl.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

#define MAX_PROC_NUM 20

// GLOBALS
static volatile sig_atomic_t counter =
    0; // con questa dichiarazione dico al processore di non ottimizzare questa
       // variabile

// il parametro int è abbligatorio per tutti i segnali
void manager(int signo) {
  printf("Il processo %d ha eseguito %d iterazioni per il segnale %d\n",
         getpid(), counter, signo);
  exit(0);
}

int main(int argc, char **argv) {
  int *pid, Nf = 5, Nsec = 2, i, status;

  // args check
  if (argc != 3) {
    fprintf(stderr, "[Errore]: \n");
    exit(1);
  }

  pid = (int *)malloc(Nf * sizeof(int));
  for (i = 0; i < Nf; i++) {
    pid[i] = fork();

    if (pid < 0) {
      perror("Errore nella fork\n");
      exit(5);
    } else if (pid[i] == 0) {
      // imposto la gestione di SIGUSR1 con sigaction
      struct sigaction sa;
      sigemptyset(&sa.sa_mask);
      sa.sa_flags = 0;
      sa.sa_handler = manager;
      if (sigaction(SIGUSR1, &sa, NULL) < 0) {
        perror("Errore nella sigaction\n");
        exit(-3);
      }

      while (1) {
        sleep(1);
        counter++;
      }
    }
  }

  sleep(Nsec);

  for (i = 0; i < Nf; i++) {
    kill(pid[i], SIGUSR1);
  }

  free(pid);

  for (i = 0; i < Nf; i++) {
    wait(&status);
  }

  return 0;
}
