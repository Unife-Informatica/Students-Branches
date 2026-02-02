#include <fcntl.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

#define BUFFER_SIZE 1024

unsigned int counter = 0;

void handler(int sig) {
    printf("\nTotale richieste: %d\n", counter);
    exit(0);
}

int main(int argc, char **argv) {
    char show_name[100];
    int n;
    int pipe1[2], pipe2[2], pipe3[2];

    signal(SIGINT, handler);

    while (1) {
        printf("Inserisci il nome dello spettacolo: ");
        scanf("%s", show_name);

        printf("Inserisci il numero di spettacoli: ");
        scanf("%d", &n);

        counter++;

        pipe(pipe1);
        pipe(pipe2);
        pipe(pipe3);

        pid_t pid1 = fork();
        if (pid1 == 0) {
            close(pipe1[1]);
            close(pipe2[0]);
            dup2(pipe1[0], STDIN_FILENO);
            dup2(pipe2[1], STDOUT_FILENO);
            execlp("grep", "grep", NULL);
            perror("execlp grep");
            exit(1);
        }

        pid_t pid2 = fork();
        if (pid2 == 0) {
            close(pipe2[1]);
            close(pipe3[0]);
            dup2(pipe2[0], STDIN_FILENO);
            dup2(pipe3[1], STDOUT_FILENO);
            execlp("sort", "sort", NULL);
            perror("execlp sort");
            exit(1);
        }

        pid_t pid3 = fork();
        if (pid3 == 0) {
            close(pipe3[1]);
            char n_str[10];
            sprintf(n_str, "%d", n);
            dup2(pipe3[0], STDIN_FILENO);
            execlp("head", "head", "-n", n_str, NULL);
            perror("execlp head");
            exit(1);
        }

        // Padre: scrive input a P1
        close(pipe1[0]);
        write(pipe1[1], show_name, strlen(show_name));
        close(pipe1[1]);

        // Padre: legge output da P3
        close(pipe3[1]);
        char buffer[BUFFER_SIZE];
        int bytes = read(pipe3[0], buffer, sizeof(buffer) - 1);
        if (bytes > 0) {
            buffer[bytes] = '\0';
            printf("Risultati:\n%s\n", buffer);
        }
        close(pipe3[0]);

        wait(NULL);
        wait(NULL);
        wait(NULL);
    }

    return 0;
}
