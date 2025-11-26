#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/wait.h>

pid_t glob_pid = -1;  

void reload_config(int sig){
    printf("Worker: reload config\n");
}

void print_stats(int sig){
    printf("Worker: stats => everything works well\n");
}

void stop_all(int sig){
    printf("Supervisor: Ctrl+C received. Terminate worker...\n");
    if(glob_pid > 0)
        kill(glob_pid, SIGTERM);
    exit(0);
}
int main(int argc, char **argv){
    pid_t pid = fork();
    if(pid < 0){
        perror("fork");
        exit(1);
    }

    if(pid == 0){
        // FIGLIO
        struct sigaction sa_1;
        sigemptyset(&sa_1.sa_mask);
        sa_1.sa_flags = 0;
        sa_1.sa_handler = reload_config;
        sigaction(SIGUSR1, &sa_1, NULL);

        struct sigaction sa_2;
        sigemptyset(&sa_2.sa_mask);
        sa_2.sa_flags = 0;
        sa_2.sa_handler = print_stats;
        sigaction(SIGUSR2, &sa_2, NULL);

        printf("Worker: started. PID %d\n", getpid());

        while(1){
            pause(); // attende segnali
        }
    } else {
        // PADRE
        glob_pid = pid;   // salva PID figlio

        printf("Supervisor: created son, PID %d\n", pid);

        struct sigaction sa_int;
        sa_int.sa_handler = stop_all;
        sigemptyset(&sa_int.sa_mask);
        sa_int.sa_flags = 0;
        sigaction(SIGINT, &sa_int, NULL);

        while(1){
            sleep(5);
            printf("Supervisor: sent SIGUSR1(print)\n");
            kill(glob_pid, SIGUSR1);

            sleep(2);
            printf("Supervisor: sent SIGUSR2(stats)\n");
            kill(glob_pid, SIGUSR2);
        }
    }

    return 0;
}
