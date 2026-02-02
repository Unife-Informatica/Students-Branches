#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

int main(int argc, char **argv) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s <directory>\n", argv[0]);
        return 1;
    }

    char to_open[256], cliente[10];
    int time, n;

    while (1) {
        printf("Inserisci cliente, tempo e numero di righe: ");
        if (scanf("%9s %d %d", cliente, &time, &n) != 3) {
            fprintf(stderr, "Input non valido\n");
            break;
        }

        sprintf(to_open, "%s/%d.tran", argv[1], time);

        int p1p2[2], p2p3[2];
        if (pipe(p1p2) == -1 || pipe(p2p3) == -1) {
            perror("pipe");
            exit(1);
        }

        pid_t p1 = fork();
        if (p1 == -1) { perror("fork"); exit(1); }
        if (p1 == 0) {
            // Processo 1: grep
            close(p1p2[0]);          // chiudo lettura
            dup2(p1p2[1], STDOUT_FILENO); // stdout → pipe
            close(p1p2[1]);

            close(p2p3[0]); close(p2p3[1]); // non usa p2p3

            execlp("grep", "grep", cliente, to_open, NULL);
            perror("execlp grep");
            exit(1);
        }

        pid_t p2 = fork();
        if (p2 == -1) { perror("fork"); exit(1); }
        if (p2 == 0) {
            // Processo 2: sort -r
            close(p1p2[1]);          // chiudo scrittura da pipe1
            dup2(p1p2[0], STDIN_FILENO);  // stdin ← pipe1
            close(p1p2[0]);

            close(p2p3[0]);          // chiudo lettura di pipe2
            dup2(p2p3[1], STDOUT_FILENO); // stdout → pipe2
            close(p2p3[1]);

            execlp("sort", "sort", "-r", NULL);
            perror("execlp sort");
            exit(1);
        }

        pid_t p3 = fork();
        if (p3 == -1) { perror("fork"); exit(1); }
        if (p3 == 0) {
            // Processo 3: head -n N > file.txt
            close(p2p3[1]);          // chiudo scrittura di pipe2
            dup2(p2p3[0], STDIN_FILENO); // stdin ← pipe2
            close(p2p3[0]);

            int fd = open("file.txt", O_CREAT | O_WRONLY | O_TRUNC, 0666);
            if (fd == -1) { perror("open file.txt"); exit(1); }
            dup2(fd, STDOUT_FILENO); // stdout → file
            close(fd);

            char n_str[16];
            sprintf(n_str, "%d", n);

            execlp("head", "head", "-n", n_str, NULL);
            perror("execlp head");
            exit(1);
        }

        // Padre: chiude tutte le pipe e aspetta i figli
        close(p1p2[0]); close(p1p2[1]);
        close(p2p3[0]); close(p2p3[1]);

        waitpid(p1, NULL, 0);
        waitpid(p2, NULL, 0);
        waitpid(p3, NULL, 0);

        printf("Operazione completata.\n");
    }

    return 0;
}
