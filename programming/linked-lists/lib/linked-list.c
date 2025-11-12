#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "linked-list.h"

// Fa puntare pl a una lista non ordinata di n elementi (n <= 10)
void randomInit(Lista* pl, int n) {
    // Gli elementi da inserire nella lista
    int a[] = {6, 2, 3, 2, 4, 7, 0, 2, 5, 1};
    int i;

    // Per i che va da 0 a n - 1
    for (i = 0; i < n; i++) {
        // Alloca memoria per un nuovo nodo
        Node* nuovoNodo = (Node*)malloc(sizeof(Node));
        if (nuovoNodo == NULL) { // Controlla che malloc non fallisca
            fprintf(stderr, "Errore: memoria insufficiente\n");
            exit(1);
        }
        
        // Assegna i valori al nuovo nodo
        nuovoNodo->data = a[i];
        nuovoNodo->next = NULL;

        // Collega il nuovo nodo alla lista
        *pl = nuovoNodo;
        pl = &((*pl)->next); // Passa al puntatore al campo next
    }
}

// Stampa tutti i valori interni alla lista
void printList(Lista l) {

    // Quando l arriva all'ultimo elemento, l varrà NULL
    while (l != NULL) {
        printf("%d\n", l->data);
        fflush(stdout);
        l = l->next;
    }
}

// Calcola il massimo valore della lista
int massimo(Lista l) {
    int max;

    if(l == NULL) {
        printf("Errore: lista vuota");
        return;
    }

    // assegna a max il primo valore della lista
    max = l->data;
    l = l->next;

    // confronta ogni elemento con max
    while(l != NULL) {
        max = l->data > max ? l->data : max;
        l = l->data;
    }

    return max;
}

