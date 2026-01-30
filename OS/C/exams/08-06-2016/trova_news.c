#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char **argv) {
  char argomento[20], data[9], to_open[100], buffer[100];
  int fd, pipe[2], counter = 0, status;
  pid_t pid_1, pid_2;

  if (argc != 2) {
    fprintf(stderr, "Uso: %s <abs_dir>\n", argv[0]);
    exit(-1);
  }

  if (argv[1][0] != '/') {
    fprintf(stderr, "[Errore]: il percorso deve essere assoluto.");
    exit(-2);
  }

  if ((fd = open(argv[1], O_DIRECTORY) < 0)) {
    perror("open");
    exit(-3);
  }
  close(fd);

  printf("Inserire l'argomento d'interesse (\"fine\" per usire): ");
  scanf("%s", argomento);
  while (strcmp(argomento, "fine") != 0) {
    printf("Inserire la data (YYYYMMDD): ");
    scanf("%s", data);

    sprintf(to_open, "%s/%s.txt", argv[1], data);
    if ((fd = open(to_open, O_RDONLY) != -1)) {
      fprintf(stderr, "Errore nell'apertura del file %s\n", to_open);

      if (errno == ENOENT) {
        fprintf(stderr, "Il file non esiste\n");
      }
    } else {
      close(fd);

      pipe(pipe);

      if ((pid_1 = fork()) < 0) {
        perror("fork");
        exit(-4);
      } else if (pid_1 == 0) {
        close(pipe[0]); // chiudo l'estremità di lettura
        close(1);       // chiudo il canale che manda l'output allo schermo
        dup(pipe[1]);   // collego stdout alla pipe di scrittura in modo da
                        // redirezionare l'output sa che lo deve collegare all'1
                        // perche è stato chiuso precedentemente
        close(pipe[1]); // chiudo l'estremità di scrittura

        execlp("grep", "grep", argomento, to_open, NULL);
        perror("grep");
        exit(-5);
      } else {
        if ((pid_2 = fork()) < 0) {
          perror("fork");
          exit(-6);
        } else if (pid_2 > 0) {
          close(pipe[1]);
          close(0);
          dup(pipe[0]);
          close(pipe[0]);

          execlp("grep", "grep", "-r", "-n", NULL);

          perror("sort");
          exit(-7);
        }

        counter++;
        close(pipe[0]);
        close(pipe[1]);
        wait(&status);
        wait(&status);
      }
    }
    printf("Inserire l'argomento d'interesse (\"fine\" per usire): ");
    scanf("%s", argomento);
  }
  printf("Sono state eseguite %d richieste", counter);
  return 0;
}
