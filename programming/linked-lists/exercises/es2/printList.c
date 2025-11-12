#include <stdio.h>
#include <stdlib.h>

typedef int Dato;

typedef struct nodo {
    Dato dato;
    struct nodo *next;
} Nodo;

typedef Nodo *Lista;

// Fa puntare pl a una lista non ordinata di n elementi (n <= 10)
void listaNonOrdinata(Lista* pl, int n) {
    // Gli elementi da inserire nella lista
    int a[] = {6, 2, 3, 2, 4, 7, 0, 2, 5, 1};
    int i;

    // Per i che va da 0 a n - 1
    for (i = 0; i < n; i++) {
        // Alloca memoria per un nuovo nodo
        Nodo* nuovoNodo = (Nodo*)malloc(sizeof(Nodo));
        if (nuovoNodo == NULL) { // Controlla che malloc non fallisca
            fprintf(stderr, "Errore: memoria insufficiente\n");
            exit(1);
        }
        
        // Assegna i valori al nuovo nodo
        nuovoNodo->dato = a[i];
        nuovoNodo->next = NULL;

        // Collega il nuovo nodo alla lista
        *pl = nuovoNodo;
        pl = &((*pl)->next); // Passa al puntatore al campo next
    }
}

// Conta i nodi all'interno della lista
int listLenght(Lista l) {
    int c = 0;

    // Quando l arriva all'ultimo elemento, l varrà NULL
    while (l != NULL) {
        c++;
        l = l->next;
    }

    return c;
}

int main() {
    Lista l = NULL; // Inizializza la lista a NULL

    // Crea una lista non ordinata di 5 elementi
    listaNonOrdinata(&l, 5);

    // Stampa la lunghezza della lista
    printf("Lunghezza della lista: %d\n", listLenght(l));

    return 0;
}
