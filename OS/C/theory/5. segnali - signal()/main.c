#include <signal.h>
#include <stdio.h>

/*
 * segnale = evento da inviare al processo in esecuzione
 *
 * non tutti i segnali sono castomizzabili. UNIX fornisce solo SIGUSR1e SIGUSR2
 */

void gestisci_sigusr(int signal_id) {
    if(signal_id == SIGUSR1) {
        printf("Ho ricevuto SIGUSR1: %d\n", signal_id);
    }
    if(signal_id == SIGUSR2) {
        printf("Ho ricevuto SIGUSR2: %d\n", signal_id);
    }
}


int main() {
    // viene assegnata una funzione ad un segnale
    signal(SIGUSR1, gestisci_sigusr);
    signal(SIGUSR2, gestisci_sigusr);
    while (1) {
        printf("Infinity loop");
    }
}
