#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

unsigned int count = 0;

void termina(int sig) {
    printf("\nCount: %u\n", count);
    exit(0);
}

void handler(int sig) {
}

int main(int argc, char **argv) {
    char cognome[20], genere[20], limit[5], to_open[100];
    pid_t p1, p2;
    int p1p2[2];

    if (argc != 2 || argv[1][0] != '/') {
        fprintf(stderr, "Uso: %s <abs_dir>\n", argv[0]);
        exit(1);
    }

    signal(SIGINT, termina);
    signal(SIGUSR1, handler);

    while (1) {
        printf("Inserisci il cognome: ");
        scanf("%19s", cognome);

        if (strcmp(cognome, "fine") == 0)
            termina(SIGINT);

        printf("Inserisci il genere: ");
        scanf("%19s", genere);

        printf("Inserisci il limite: ");
        scanf("%4s", limit);

        sprintf(to_open, "%s/%s.txt", argv[1], genere);

        pipe(p1p2);

        p1 = fork();
        if (p1 == 0) {
            signal(SIGUSR1, handler);
            pause();   // attende main

            close(p1p2[0]);
            dup2(p1p2[1], STDOUT_FILENO);
            close(p1p2[1]);

            execlp("grep", "grep", cognome, to_open, NULL);
            perror("grep");
            exit(1);
        }

        p2 = fork();
        if (p2 == 0) {
            close(p1p2[1]);
            dup2(p1p2[0], STDIN_FILENO);
            close(p1p2[0]);

            execlp("head", "head", "-n", limit, NULL);
            perror("head");
            exit(1);
        }

        close(p1p2[0]);
        close(p1p2[1]);

        kill(p1, SIGUSR1);

        wait(NULL);
        wait(NULL);

        count++;
    }
}
