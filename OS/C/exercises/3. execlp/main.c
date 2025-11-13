#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {

  /*
  Quando un processo chiama fork(), viene creato un nuovo processo (figlio).
  Il processo padre e il figlio hanno:
    * Strutture di processo diverse (pid diversi, tabelle dei processi
  separate).
    * Spazi di memoria separati (dati, stack, heap indipendenti).
    * Ma condividono alcuni aspetti iniziali (ad esempio i file descriptor
  aperti). Dopo fork(), entrambi i processi continuano l’esecuzione da quel
  punto.
  */

  int pid = fork(); // Crea un nuovo processo

  // Se fork() restituisce un valore negativo, la creazione del figlio è fallita
  if (pid < 0) {
    perror("fork fallita");
    exit(3); // Termina il programma
  }

  // Se siamo nel processo figlio (pid == 0)
  if (pid == 0) {
    // Esegue "ls -l"
    execlp("ls", "ls", "-l", NULL);

    // Se execlp fallisce, viene eseguito il codice sotto
    perror("execlp fallita"); // Stampa l’errore
    exit(4);                  // Termina il figlio con codice 4
  }
  // Se siamo nel processo padre (pid > 0)
  else if (pid > 0) {
    // Il padre continua con la sua esecuzione normale
    printf("Sono il padre\n");
  }

  return 0;
}
