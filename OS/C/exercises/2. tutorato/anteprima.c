#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

#define DIM 50

int main(int argc, char **argv) {
  int pid, status, fd, num;
  char nome[DIM];

  // Controllo il numero degli argomenti
  if (argc != 2) {
    fprintf(stderr, "Uso: %s <num>", argv[0]);
    exit(1);
  }

  // atoi converte una stringa in intero
  if ((num = atoi(argv[1])) <= 0) {
    fprintf(stderr,
            "[Errore]: %s deve essere un intero positivo maggiore di zero\n",
            argv[1]);
    exit(2);
  }

  printf("Inserire il nome del file:\n");
  scanf("%s", nome);

  // non aggiunge \n perche sto usando la scanf
  while (strcmp(nome, "fine") != 0) {
    // provo ad aprire il file
    if ((fd = open(nome, O_RDONLY)) < 0) {
      // la open potrebbe fallire anche se il file esiste
      // ad esempio se mancano i permessi di lettura
      // errno è una variabile che viene impostata dal SO
      if (errno == ENOENT) {
        fprintf(stderr, "Il file %s non esiste\n", argv[1]);
      } else {
        // Errore generico
        perror("open");
        exit(3);
      }
    } else {
      // è necessario chiudere il file in modo da non causare un rosource leak
      close(fd);

      // creo un figlio per visualizzare l'anteprima
      pid = fork();
      if (pid < 0) {
        perror("fork");
        exit(4);
      } else if (pid == 0) {
        // FIGLIO
        printf("Anteprima del file %s:\n", nome);
        execlp("head", "head", "-n", argv[1], nome,
               NULL); // uso argv[1] perche execlp accetta solo stringhe
        // le seguenti righe vengono eseguite solo se l'execlp non è andata a
        // buonfine
        perror("exec");
        exit(5);
      }
      // PADRE
      wait(&status);
    }
    printf("Inserire il nome del file:\n");
    scanf("%s", nome);
  }

  return 0;
}
