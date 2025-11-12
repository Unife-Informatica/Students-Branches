#include <stdio.h>
#define DIM 20

typedef struct {
    char nome[DIM];
    char cognome[DIM];
    int matricola;
} Studente;

void inserimento(Studente *g) {
    printf("Inserisci nome, cognome e matricola dello studente: ");
    scanf("%s %s %d", g->nome, g->cognome, &g->matricola);
}

void stampaStudente(Studente g[], int n) {
    for (int i = 0; i < n; i++) {
        printf("Nome: %s Cognome: %s Matricola: %d\n", g[i].nome, g[i].cognome, g[i].matricola);
    }
}

int main() {
    Studente medicina[3];

    for (int i = 0; i < 3; i++) {
        inserimento(&medicina[i]);
    }

    stampaStudente(medicina, 3);

    return 0;
}
