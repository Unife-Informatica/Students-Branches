#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char **argv) {
  int pid, fd, status, i;

  if (argc < 3) {
    fprintf(stderr, "Uso: %s <nomefile> ...<stringa>\n", argv[0]);
    exit(1);
  }

  // specifico i bit di protezione perche sto creando il file
  fd = open("conteggio.txt", O_CREAT | O_TRUNC | O_WRONLY, 0644);
  if (fd < 0) {
    perror("Errore nella creazione del file di conteggio, termino");
    exit(2);
  }
  close(fd);

  // ciclo tutti i parametri
  for (i = 2; i < argc; i++) {
    pid = fork();
    if (pid < 0) {
      perror("fork");
      exit(3);
    } else if (pid == 0) {
      // FIGLIO
      char log[256];

      // apro il file in append
      fd = open("conteggio.txt", O_WRONLY | O_APPEND);

      // creo il log dell'operazione di conteggio
      // uso sprintf in modo da inserire la stringa in log al posto di stamparla
      // nello stdout
      sprintf(log, "%s %s\n", argv[1], argv[i]);

      // scrivo il log su un file
      write(fd, log, strlen(log));

      // chiudo il file
      close(fd);

      printf("Numero di righe in cui compare la stringa %s\n", argv[i]);
      execlp("grep", "grep", "-c", argv[i], argv[1], NULL);

      perror("exec");
      exit(4);
    }
  }
  // PADRE
  for (i = 2; i < argc; i++) {
    // attendo il ritorno dei processi figli
    wait(&status);
  }

  return 0;
}
