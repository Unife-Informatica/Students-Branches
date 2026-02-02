
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>

#define BUFFER_SIZE 1024
#define MAX_CHILDREN 10

int children;
pid_t pid[MAX_CHILDREN];
int pipes_in[MAX_CHILDREN][2];   // padre -> figli
int pipes_out[MAX_CHILDREN][2];  // figli -> padre

void termina(int sig) {
    for (int i = 0; i < children; i++) {
        kill(pid[i], SIGTERM);
    }
    exit(0);
}

int main(int argc, char **argv) {
    char buffer[BUFFER_SIZE];

    if (argc < 2) {
        fprintf(stderr, "Uso: %s <cantina> ...\n", argv[0]);
        exit(1);
    }

    children = argc - 1;
    if (children > MAX_CHILDREN) children = MAX_CHILDREN;

    signal(SIGINT, termina);

    // Creazione pipe e figli
    for (int i = 0; i < children; i++) {
        pipe(pipes_in[i]);
        pipe(pipes_out[i]);

        pid[i] = fork();
        if (pid[i] == 0) {
            // Figlio
            close(pipes_in[i][1]);
            close(pipes_out[i][0]);
            dup2(pipes_out[i][1], 1);
            close(pipes_out[i][1]);

            int n = read(pipes_in[i][0], buffer, BUFFER_SIZE - 1);
            buffer[n] = '\0';

            char to_open[100];
            sprintf(to_open, "/tmp/%s", argv[i + 1]);

            execlp("grep", "grep", buffer, to_open, NULL);
            exit(-1);
        }

        // Padre chiude lati non necessari
        close(pipes_in[i][0]);
        close(pipes_out[i][1]);
    }

    // Ciclo principale
    while (1) {
        printf("Termine da cercare ('fine' per uscire): ");
        fgets(buffer, BUFFER_SIZE, stdin);
        buffer[strcspn(buffer, "\n")] = 0; // rimuove newline

        if (strcmp(buffer, "fine") == 0) {
            termina(0);
        }

        for (int i = 0; i < children; i++) {
            write(pipes_in[i][1], buffer, strlen(buffer));

            int n = read(pipes_out[i][0], buffer, BUFFER_SIZE - 1);
            if (n > 0) {
                buffer[n] = '\0';
                printf("%s", buffer);
            }
        }
    }

    return 0;
}
