#include <signal.h>
#include <stdio.h>

void gestisci_sigusr(int signal_id) {
    if(signal_id == SIGUSR1) {
        printf("Ho ricevuto SIGUSR1: %d\n", signal_id);
    }
    if(signal_id == SIGUSR2) {
        printf("Ho ricevuto SIGUSR2: %d\n", signal_id);
    }
}

int main() {
    struct sigaction s_int;

    sigemptyset(&s_int.sa_mask);        // inizializza la maschera dei segnali: nessun segnale viene bloccato durante la gestione
    s_int.sa_flags = 0;                 // nessuna opzione speciale per la gestione del segnale
    s_int.sa_handler = gestisci_sigusr; // funzione handler chiamata alla ricezione del segnale
    sigaction(SIGUSR1, &s_int, NULL);   // associa l'handler e le impostazioni al segnale SIGUSR1
}
