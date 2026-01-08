#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/wait.h>

int counter = 0;
pid_t *pid;
int Nf;
volatile sig_atomic_t shutdown_flag = 0;

// ===== HANDLER FIGLI =====
void handler_sigusr1(int sig) {
    counter++;
    printf("[Client %d] Counter: %d\n", getpid(), counter);
    fflush(stdout);
}

// ===== HANDLER PADRE =====
void handler_sigint(int sig) {
    printf("\nServer: ending all processes...\n");

    shutdown_flag = 1;

    for (int i = 0; i < Nf; i++) {
        kill(pid[i], SIGTERM);
    }
}

int main(int argc, char **argv) {

    if (argc != 2) {
        fprintf(stderr, "Use: %s <num_process>\n", argv[0]);
        exit(1);
    }

    Nf = atoi(argv[1]);

    if (Nf <= 0) {
        fprintf(stderr, "The num_process must be a positive number\n");
        exit(2);
    }

    pid = malloc(Nf * sizeof(pid_t));
    if (!pid) {
        perror("malloc");
        exit(3);
    }

    // ===== CREAZIONE FIGLI =====
    for (int i = 0; i < Nf; i++) {
        pid[i] = fork();

        if (pid[i] < 0) {
            perror("fork");
            exit(4);
        }

        if (pid[i] == 0) {    // FIGLIO
            struct sigaction sa;
            sigemptyset(&sa.sa_mask);
            sa.sa_flags = 0;
            sa.sa_handler = handler_sigusr1;

            if (sigaction(SIGUSR1, &sa, NULL) < 0) {
                perror("sigaction");
                exit(5);
            }

            while (1) pause();
        }
    }

    // ===== PADRE =====
    for (int i = 0; i < Nf; i++) {
        printf("Server: connected new client %d, PID = %d\n", i, pid[i]);
    }

    // handler SIGINT per il padre
    struct sigaction sa_int;
    sigemptyset(&sa_int.sa_mask);
    sa_int.sa_flags = 0;
    sa_int.sa_handler = handler_sigint;

    if (sigaction(SIGINT, &sa_int, NULL) < 0) {
        perror("sigaction");
        exit(6);
    }

    printf("Server running. Sending SIGUSR1 every 2 seconds...\n");

    // ===== LOOP PRINCIPALE DEL PADRE =====
    while (!shutdown_flag) {

        sleep(2);  // ogni 2 secondi

        // invio SIGUSR1 a tutti i figli
        for (int i = 0; i < Nf; i++) {
            kill(pid[i], SIGUSR1);
        }
    }

    // ===== ATTENDO I FIGLI =====
    for (int i = 0; i < Nf; i++) {
        waitpid(pid[i], NULL, 0);
    }

    printf("Server: shutdown complete.\n");
    return 0;
}
