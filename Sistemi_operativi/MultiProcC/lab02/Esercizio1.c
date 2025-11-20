#include <stdio.h>
#include <signal.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

#define MAX_PROC_NUM 20

// Variabili globali
static volatile sig_atomic_t contatore = 0;

void gestore(int signo){
  printf("Il processo %d ha eseguito %d iterazioni per il segnale %d\n", getpid(), contatore, signo);
  exit(0);
}

int main(int argc, char *argv[]){
  int *pid;
  int Nf, Nsec, status;

  // Controllo argomenti
  if(argc != 3){
    fprintf(stderr, "Uso: ./itercounter <num_processi> <num_secondi>\n");
    exit(1);
  }

  Nf = atoi(argv[1]);
  if(Nf <= 0){
    fprintf(stderr, "Il parametro <num_processi> deve essere un intero positivo\n");
    exit(2);
  }

  Nsec = atoi(argv[2]);
  if(Nsec <= 0){
    fprintf(stderr, "Il parametro <num_secondi> deve essere un intero positivo\n");
    exit(3);
  }

  /* Uso un array allocato dinamicamente per poter inviare SIGUSR1
     a ogni singolo processo figlio attraverso la system call kill().
     Alternativamente, inviando il segnale a tutto il gruppo di processi
     (invocando kill(0)) non ne avrei bisogno. */

  pid = (int *) malloc(Nf * sizeof(int));

  // Genero i figli
  for(int i = 0; i < Nf; ++i){
    pid[i] = fork();
    if(pid[i] < 0){
      perror("Errore nella fork\n");
      exit(4);
    }else if(pid[i] == 0){
      // Codice del processo figlio
      // Imposto la gestione DI SIGUSR1 con sigaction
      struct sigaction sa;
      sigemptyset(&sa.sa_mask);
      sa.sa_flags = 0;
      sa.sa_handler = gestore;
      if(sigaction(SIGUSR1, &sa, NULL) < 0){
        perror("Errore in sigation, SIGUSR1 figlio\n");
        exit(-3);
      }
      while(1){
        sleep(1);
        contatore++;
      }
    }
  }
  // Sono nel codice del processo padre
  sleep(Nsec);

  // Invio SIGUSR1 a tutti i processi figli
  for(int i = 0; i < Nf; ++i){
    kill(pid[i], SIGUSR1);
  }

  /* Un'alternativa più efficiente consiste nell'invocare una sola kill(0, SIGUSR1)
     al gruppo di processi, AVENDO CURA DI FAR IGNORARE AL PADRE IL SEGNALE IN
     QUESTIONE. */

  free(pid);

  // Attendo la terminazione di tutti i figli
  // (alternativamente posso installare il gestore per SIGCHLD)
  for(int i = 0; i < Nf; i++){
    wait(&status);
  }

  // Esco senza errori
  return 0;
}