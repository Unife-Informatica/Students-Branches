#include <stdio.h>
#include <stdlib.h>

typedef struct nodo {
    int dato;            // Valore del nodo
    struct nodo *next;   // Puntatore al nodo successivo
} Nodo;

typedef Nodo *Lista;

// Fa puntare pl a una lista non ordinata di n elementi
void listaNonOrdinata(Lista* pl, int n) {
    int i, valore;
    for (i = 0; i < n; i++) {
        printf("Inserisci il %d valore: ", i + 1);
        scanf("%d", &valore);

        // *pl punta a un nuovo nodo
        (*pl) = (Nodo*)malloc(sizeof(Nodo));
        if (*pl == NULL) { // Controllo dell'allocazione
            printf("Errore: memoria insufficiente.\n");
            exit(1);
        }
        (*pl)->dato = valore;   // Assegna il valore
        (*pl)->next = NULL;     // L'ultimo nodo punta a NULL
        pl = &(*pl)->next;      // Avanza al prossimo nodo
    }
}

// Stampa i valori della lista
void stampa(Lista l) {
    while (l != NULL) {
        printf("%d\n", l->dato);  // Stampa il valore del nodo
        l = l->next;              // Passa al nodo successivo
    }
}

int main() {
    Lista l = NULL;  // Inizializziamo la lista come vuota
    int n;

    printf("Quanti valori vuoi inserire (max 10)? ");
    scanf("%d", &n);

    if (n > 10 || n <= 0) {
        printf("Errore: il numero deve essere compreso tra 1 e 10.\n");
        return 1;
    }

    listaNonOrdinata(&l, n);  // Popoliamo la lista
    printf("\nValori nella lista:\n");
    stampa(l);                // Stampiamo i valori della lista

    return 0;
}
