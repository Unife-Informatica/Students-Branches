#include <stdio.h>
#include <stdlib.h>
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
  char buffer[1024];

  pipe(fd); // crea la pipe

  pid = fork(); // crea un processo figlio

  if (pid < 0) {
    perror("fork");
    exit(1);
  }

  if (pid == 0) {
    // FIGLIO
    close(fd[1]);
    /*
     * * read(da_dove_leggere, buffer, buffer_size)
     * * la funzione ritorna -1 se in errore altrimenti
     *   i byte ricevuti
     * * tolgo 1 dalla lunghezza del buffer per inserire il terminatore
     */
    int n = read(fd[0], buffer, sizeof(buffer) - 1);
    if(n < 0) {
        perror("read");
        exit(-2);
    }

    buffer[n] = '\0'; // aggiungo il terminatore di stringa
    printf("Messaggio ricevuto: %s", buffer);

    close(fd[0]);
  } else {
    // PADRE
    close(fd[0]);
    char placeholder[] = "Inserisci il messaggio: ";
    write(1, placeholder, sizeof(placeholder));

    int n = read(0, buffer, sizeof(buffer) - 1); // tolgo 1 per avere lo spazio per il terminatore
    if (n < 0) {
        perror("read");
        exit(-1);
    }

    // aggiungo il terminatore sia prima dell'invio sia dopo
    // perche la write manda solo il numero di byte definiti
    buffer[n] = '\0';

    if (write(fd[1], buffer, n) < 0) {
        perror("write");
        exit(-1);
    }

    close(fd[1]);
  }

  return 0;
}
