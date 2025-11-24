#include <fcntl.h>
#include <signal.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

/*
 * ATTENZIONE! quando invio il segnale SIGINT arriva sia al padre che ai figli.
 * è per questo che non devo lanciare il segnale di arresto e posso mettere il
 * padre direttamente in stato di attesa.
 */

static volatile sig_atomic_t counter = 0;
static volatile sig_atomic_t child_index;
static volatile sig_atomic_t n_children;
static volatile sig_atomic_t flagTerminato = false;

void sigusr1_handler(int signo) {
  counter++;
  printf("Figlio %d ha incrementato il contatore a %d\n", child_index, counter);
}

void sigusr2_handler(int signo) {
  counter--;
  printf("Figlio %d ha decrementato il contatore a %d\n", child_index, counter);
}

void sigintchild_handler(int signo) {
  printf("Terminazione del figlio %d con counter a valore %d\n", child_index,
         counter);
  exit(0);
}

void sigintparent_handler(int signo) {
  printf("\nRicevuto Ctrl+C nel padre --> attendo terminazione figli\n");
  int status;
  for (int i = 0; i < n_children; i++) {
    wait(&status);
  }
  printf("Tutti i figli terminati. Chiudo il programma.\n");
  flagTerminato = true;
}

int main(int argc, char **argv) {
  struct sigaction sigintchild, sigusr1, sigusr2, sigintparent;
  pid_t *children;

  if (argc != 2) {
    fprintf(stderr, "Uso corretto: %s <n_figli>\n", argv[0]);
    exit(1);
  }

  n_children = atoi(argv[1]);
  if (n_children <= 0) {
    fprintf(stderr, "Serve almeno un child da generare\n");
    exit(2);
  }

  children = (pid_t *)malloc(n_children * sizeof(pid_t));
  if (!children) {
    perror("malloc");
    exit(3);
  }

  // Creo i figli
  for (int i = 0; i < n_children; i++) {
    pid_t pid = fork();

    if (pid == 0) {
      // Figlio
      child_index = i;

      // Handler SIGINT per il figlio
      sigemptyset(&sigintchild.sa_mask);
      sigintchild.sa_flags = 0;
      sigintchild.sa_handler = sigintchild_handler;
      if (sigaction(SIGINT, &sigintchild, NULL) == -1) {
        perror("Errore installazione SIGINT figlio");
        exit(3);
      }

      // Handler SIGUSR1
      sigemptyset(&sigusr1.sa_mask);
      sigusr1.sa_flags = 0;
      sigusr1.sa_handler = sigusr1_handler;
      if (sigaction(SIGUSR1, &sigusr1, NULL) == -1) {
        perror("Errore installazione SIGUSR1 figlio");
        exit(3);
      }

      // Handler SIGUSR2
      sigemptyset(&sigusr2.sa_mask);
      sigusr2.sa_flags = 0;
      sigusr2.sa_handler = sigusr2_handler;
      if (sigaction(SIGUSR2, &sigusr2, NULL) == -1) {
        perror("Errore installazione SIGUSR2 figlio");
        exit(3);
      }

      // Figlio in attesa di segnali
      while (1) {
        pause();
      }

    } else if (pid > 0) {
      // Padre
      children[i] = pid;
    } else {
      perror("fork");
      exit(4);
    }
  }

  // Handler SIGINT per il padre
  sigemptyset(&sigintparent.sa_mask);
  sigintparent.sa_flags = 0;
  sigintparent.sa_handler = sigintparent_handler;
  if (sigaction(SIGINT, &sigintparent, NULL) == -1) {
    perror("Errore installazione SIGINT padre");
    exit(5);
  }

  // Attendere un attimo per assicurarsi che i figli abbiano installato gli
  // handler
  sleep(1);

  // Padre invia segnali casuali ai figli
  while (!flagTerminato) {
    int random_index = rand() % n_children;
    int sig = (rand() % 2 ? SIGUSR1 : SIGUSR2);
    kill(children[random_index], sig);
    sleep(2);
  }

  free(children);
  return 0;
}
