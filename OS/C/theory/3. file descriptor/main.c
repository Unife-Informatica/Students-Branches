#include <stdio.h>
#include <string.h>
#include <unistd.h>

/*
 * 1. Il padre crea una pipe.
 * 2. Dopo fork(), padre e figlio condividono gli stessi file descriptor.
 * 3. Il padre chiude la parte di lettura e scrive un messaggio.
 * 4. Il figlio chiude la parte di scrittura e legge dalla pipe.
 * 5. Il figlio stampa il messaggio ricevuto.
 */

int main() {
  int fd[2];
  pid_t pid;
  char buffer[50];

  pipe(fd); // crea la pipe

  pid = fork(); // crea un processo figlio

  if (pid == 0) {
    // Processo figlio
    close(fd[1]); // chiude estremità di scrittura
    read(fd[0], buffer, sizeof(buffer));
    printf("Figlio ha letto: %s\n", buffer);
    close(fd[0]);
  } else {
    // Processo padre
    close(fd[0]); // chiude estremità di lettura
    char messaggio[] = "Ciao dal padre!";
    write(fd[1], messaggio, strlen(messaggio) + 1);
    close(fd[1]);
  }

  return 0;
}
