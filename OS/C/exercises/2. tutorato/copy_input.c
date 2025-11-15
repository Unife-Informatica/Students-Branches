#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(int argc, char **argv) {
  int fd;
  char buff[1024];

  // Controllo gli argomenti
  if (argc != 2) {
    fprintf(stderr, "Uso: %s filename", argv[0]);
    exit(1);
  }

  // Creo il file usando la syscall open()
  // il secondo parametro definisce le operazioni che voglio eseguire
  // all'apertura del file
  // - O_WRONLY = apro il file in sola lettura
  // - O_TRUNC = se il file esiste lo svuoto
  // - O_CREAT = se il file non esiste lo creo
  // 0644 = rw-r--r-- (specifico i bit di protezione perche sono in fase di
  // creazione)
  fd = open(argv[1], O_WRONLY | O_TRUNC | O_CREAT, 0644);
  if (fd < 0) {
    fprintf(stderr, "[Errore]: errore durante la creazione del file %s\n",
            argv[1]);
    exit(2);
  }

  // fgets è una funzione che preleva una linea da uno stream (es. stdin)
  printf("Inserire una stringa:\n");
  fgets(buff, 1024, stdin);

  // dentro strcmp devo includere \n perche la fgets ritornarna anche il
  // carattere di new line
  while (strcmp(buff, "fine\n") != 0) {
    write(fd, buff, strlen(buff));
    printf("Inserire una stringa:\n");
    fgets(buff, 1024, stdin);
  }

  close(fd);

  return 0;
}
