#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>

volatile int contatore = 0;  // contatore del figlio

void gestore_sigusr1(int sig) {
    printf("Son: PID %d: counter = %d (terminating)\n", getpid(), contatore);
    fflush(stdout);
    exit(0);  // termina il figlio quando riceve SIGUSR1
}

int main(int argc, char **argv) {
    if (argc != 3) {
        fprintf(stderr, "Uso: %s <num_figli> <num_secondi>\n", argv[0]);
        exit(1);
    }

    int N = atoi(argv[1]);
    int T = atoi(argv[2]);

    if (N <= 0 || T <= 0) {
        fprintf(stderr, "I parametri devono essere numeri positivi\n");
        exit(2);
    }

    pid_t *pid = malloc(N * sizeof(pid_t));
    if (!pid) {
        perror("malloc");
        exit(3);
    }

    printf("Father: create %d sons. Waiting %d second...\n", N, T);
    fflush(stdout);

    // Creazione dei figli
    for (int i = 0; i < N; i++) {
        pid[i] = fork();

        if (pid[i] < 0) {
            perror("fork");
            exit(4);
        } else if (pid[i] == 0) {
            // CODICE FIGLIO
            contatore = i; // offset iniziale per distinguere figli

            struct sigaction sa;
            memset(&sa, 0, sizeof(sa));
            sigemptyset(&sa.sa_mask);
            sa.sa_flags = 0;
            sa.sa_handler = gestore_sigusr1;

            if (sigaction(SIGUSR1, &sa, NULL) < 0) {
                perror("sigaction");
                exit(5);
            }

            // ciclo infinito: incrementa e stampa contatore ogni secondo
            while (1) {
                sleep(1);
                contatore++;
                printf("Son: PID %d: counter = %d\n", getpid(), contatore);
                fflush(stdout);
            }
        }
    }

    // CODICE PADRE
    sleep(T); // aspetta T secondi

    printf("Father: sending SIGUSR1 to all sons...\n");
    fflush(stdout);

    // Invio SIGUSR1 a tutti i figli
    for (int i = 0; i < N; i++) {
        kill(pid[i], SIGUSR1);
    }

    // Aspetta che tutti i figli terminino
    for (int i = 0; i < N; i++) {
        wait(NULL);
    }

    printf("Father: all sons terminated.\n");
    free(pid);

    return 0;
}
