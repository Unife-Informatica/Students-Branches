#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

char *FILE_DIR = "/var/local/ticket";

int main(int argc, char **argv) {
  int fd, pipe_1[2], pipe_2[2];
  char to_open[20], giorno[4], mese[3], anno[3], data[9];
  pid_t pid_1, pid_2, pid_3;

  if (argc != 3) {
    fprintf(stderr, "Uso: %s <destinazione> <N>\n", argv[0]);
    exit(-1);
  }

  sprintf(to_open, "%s/%s.txt", FILE_DIR, argv[1]);

  if ((fd = open(to_open, O_RDONLY)) < 0) {
    fprintf(stderr, "[Errore]: file inesistente\n");
    exit(-2);
  }
  close(fd);

  printf("Inserisci la data (DD MM YYYY): ");
  scanf("%s %s %s", giorno, mese, anno);
  sprintf(data, "%s%s%s", giorno, mese, anno);

  pipe(pipe_1);
  pipe(pipe_2);

  if ((pid_1 = fork()) < 0) {
    fprintf(stderr, "[Errore]: errore nella creazione della fork: %s",
            strerror(errno));
    exit(-3);
  } else if (pid_1 == 0) {
    close(pipe_2[0]);
    close(pipe_2[1]);
    close(pipe_1[0]);
    close(1);
    dup(pipe_1[1]);
    close(pipe_1[1]);

    execlp("grep", "grep", data, to_open, NULL);

    fprintf(stderr, "[Errore]: %s", strerror(errno));
    exit(-4);
  } else {
    if ((pid_2 = fork()) < 0) {
      fprintf(stderr, "[Errore]: errore nella creazione della fork: %s",
              strerror(errno));
      exit(-5);
    } else if (pid_2 == 0) {
        close(pipe_1[1]);
        dup2(pipe_1[0], 0);
        close(pipe_1[0]);

        close(pipe_2[0]);
        dup2(pipe_2[1], 1);
        close(pipe_2[1]);

      execlp("sort", "sort", "-r", NULL);

      fprintf(stderr, "[Errore]: %s", strerror(errno));
      exit(-6);
    } else {
      if ((pid_3 = fork()) < 0) {
        fprintf(stderr, "[Errore]: errore nella creazione della fork: %s",
                strerror(errno));
        exit(-7);
      } else if (pid_3 == 0) {
          close(pipe_1[0]);
          close(pipe_1[1]);

          close(pipe_2[1]);
          dup2(pipe_2[0], 0);
          close(pipe_2[0]);

        execlp("head", "head", "-n", argv[2], NULL);

        fprintf(stderr, "[Errore]: %s", strerror(errno));
        exit(-8);
      }
    }
  }

  close(pipe_1[0]);
  close(pipe_1[1]);
  close(pipe_1[0]);
  close(pipe_1[1]);
  wait(NULL);
  wait(NULL);
  wait(NULL);
}
