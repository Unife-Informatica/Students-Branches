#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

#define DIM 100
#define MAX_PROC 20 // evito di generare troppi processi
/*
Esercizio: Visualizza messaggio
*/

int main(int argc, char **argv)
{
  pid_t pid;
  int status, N;
  char buffer[DIM];
  int pipes[MAX_PROC][2];

  if (argc != 2)
  { // Controllo numero argomenti
    fprintf(stderr, "Uso: ./visualizza_fork <num_fork> \n");
    exit(1);
  }

  // controllo che l'argomento sia un intero
  for (int i = 0; i < strlen(argv[1]); i++)
  {
    if ((argv[1][i] < '0') || (argv[1][i] > '9'))
    {
      fprintf(stderr, "Il parametro <timeout> deve essere un intero positivo\n");
      exit(2);
    }
  }

  N = atoi(argv[1]);
  if (N > MAX_PROC)
  { // Controllo importante per evitare crash
    fprintf(stderr, "Numero processi richiesto troppo grande\n");
    exit(3);
  }

  // Creo N pipes
  for (int i = 0; i < N; i++)
  {
    if (pipe(pipes[i]) == -1)
    {
      perror("pipe");
      exit(4);
    }
  }

  // Creo N processi figlio
  for (int i = 0; i < N; i++)
  {
    pid = fork();

    if (pid < 0)
    {
      perror("Errore creazione fork");
      exit(5);
    }

    if (pid == 0)
    { // Processo figlio
      // Chiudo la pipe dalla parte in lettura per il processo figlio
      close(pipes[i][0]);

      // Creo il messaggio per questo figlio e lo scrivo sulla pipe
      sprintf(buffer, "Hello world! sono il processo: %d\n", getpid());
      write(pipes[i][1], buffer, strlen(buffer) + 1);

      // Chiudo la parte in scrittura per la pipe del figlio, poi termino il figlio
      close(pipes[i][1]);
      exit(0);
    }
    else
    {
      // Il processo padre non scrive niente sulle pipe, chiudo la parte in scrittura
      close(pipes[i][1]);
    }
  }

  for (int i = 0; i < N; i++)
  {
    // Il padre legge dalle pipe e le chiude
    read(pipes[i][0], buffer, DIM);
    printf("Il processo figlio %d dice: %s", i, buffer);

    close(pipes[i][0]);
  }

  // Il processo padre attende la terminazione di tutti i processi figlio
  for (int i = 0; i < N; i++)
  {
    wait(&status);
  }

  return 0;
}