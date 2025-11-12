#include <stdio.h>
#include <stdlib.h>

typedef struct nodo {
    int dato;
    struct nodo* next;
} Nodo;

typedef Nodo* Lista;

void inserisciInFondo(Lista* pl, int valore) {
    Nodo* nuovo = (Nodo*)malloc(sizeof(Nodo));
    nuovo->dato = valore;
    nuovo->next = NULL;

    if (*pl == NULL) {
        *pl = nuovo;
    } else {
        Nodo* temp = *pl;
        while (temp->next != NULL)
            temp = temp->next;
        temp->next = nuovo;
    }
}

void inizializza(Lista* pl) {
    char matricola[] = "205330";

    for (int i = 0; matricola[i] != '\0'; i++) {
        int cifra = matricola[i] - '0';
        inserisciInFondo(pl, cifra);
    }
}

int main() {
    int i, a[10] = {0};
    Lista l = NULL;

    inizializza(&l);

    for (; l; l = l->next) {
        if (l->dato != 0)
            a[l->dato] = l->dato;
    }

    for (i = 0; i < 10; i++)
        printf("%d", a[i]);
    printf("\n");

    return 0;
}
