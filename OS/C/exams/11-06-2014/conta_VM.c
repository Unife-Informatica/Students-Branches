#include <errno.h>
#include <fcntl.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

unsigned int counter = 0;

void terminazione(int signal_id) {
    printf("\nCi sono state eseguite %d richieste.\n", counter);
    exit(EXIT_SUCCESS);
}

int main(int argc, char **argv) {
    struct sigaction sig;
    int fd, fd_pipe[2];
    char nome_fornitore[20], nome_applicazione[20], to_open[100];
    pid_t pid_1, pid_2;

    if(argc != 2) {
        fprintf(stderr, "Uso: %s <abs_dir>", argv[0]);
        exit(-1);
    }

    if(argv[1][0] != '/') {
        fprintf(stderr, "[Errore]: la directory deve essere assoluta");
        exit(-2);
    }

    if((fd = open(argv[1], O_DIRECTORY)) < 0) {
        fprintf(stderr, "[Errore]: la directory %s non esiste\n", argv[1]);
        exit(-3);
    }
    close(fd);

    sigemptyset(&sig.sa_mask);
    sig.sa_flags = 0;
    sig.sa_handler = terminazione;
    sigaction(SIGINT, &sig, NULL);

    while (1) {
        printf("Inserire il nome del fornitore: ");
        scanf("%s", nome_fornitore);
        if(strcmp(nome_fornitore, "fine") == 0) terminazione(SIGINT);
        printf("Inserire il nome dell'applicazione: ");
        scanf("%s", nome_applicazione);
        if(strcmp(nome_applicazione, "fine") == 0) terminazione(SIGINT);

        sprintf(to_open, "%s/%s.txt", argv[1], nome_fornitore);

        if((fd = open(to_open, O_RDONLY)) < 0) {
            fprintf(stderr, "[Errore]: errore nell'apertura di %s", to_open);
            exit(-4);
        }
        close(fd);

        pipe(fd_pipe);

        if((pid_1 = fork()) < 0) {
            fprintf(stderr, "[Errore]: errore durante la creazione della fork: %s", strerror(errno));
            exit(-5);
        } else if (pid_1 == 0) {
            close(fd_pipe[0]);
            close(1);
            dup(fd_pipe[1]);
            close(fd_pipe[1]);

            execlp("grep", "grep", nome_applicazione, to_open, NULL);

            fprintf(stderr, "[Errore]: %s", strerror(errno));
            exit(-6);
        } else {
            if((pid_2 = fork()) < 0) {
                fprintf(stderr, "[Errore]: errore durante la creazione della fork: %s", strerror(errno));
                exit(-5);
            } else if (pid_2 == 0) {
                close(fd_pipe[1]);
                dup(fd_pipe[0]);
                close(fd_pipe[0]);

                execlp("grep", "grep", "-c", "operativa", NULL);

                fprintf(stderr, "[Errore]: %s", strerror(errno));
                exit(-6);
            }
        }
        close(fd_pipe[0]);
        close(fd_pipe[1]);
        wait(NULL);
        wait(NULL);
        counter++;


    }
}
