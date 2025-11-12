#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "listaNazioni.h"

void nuovaLista(Lista *l)
{
    *l = NULL;
}

void inserisciTesta(Lista *l, Paese p) {
    Nodo *aux;
    aux = (Nodo *)malloc(sizeof(Nodo));

    aux->p = p;
    aux->next = *l;
    *l = aux;
}

void addItem(Lista *l, char nome[10], int posizione)
{
    while ((*l) != NULL && strcmp((*l)->p.nome, nome) != 0)
        l = &((*l)->next);
    if ((*l) == NULL)
    {
        // creazione nodo
        Paese p;
        strcpy(p.nome, nome);
        p.oro = 0;
        p.argento = 0;
        p.bronzo = 0;

        inserisciTesta(l, p);
    }

    // winners manager
    switch (posizione)
    {
    case 1:
        (*l)->p.oro++;
        break;
    case 2:
        (*l)->p.argento++;
        break;
    case 3:
        (*l)->p.bronzo++;
        break;
    }
}

int comparaPaesi(Paese *a, Paese *b) {
    if (a->oro != b->oro) {
        return b->oro - a->oro;
    }
    if (a->argento != b->argento) {
        return b->argento - a->argento;
    }
    return b->bronzo - a->bronzo;
}

void sortList(Lista *l) {
    if (*l == NULL || (*l)->next == NULL) {
        return;
    }

    Nodo *sorted = NULL; // Lista ordinata
    Nodo *current = *l; // Lista originale
    Nodo *prev = NULL;
    Nodo *next = NULL;

    while (current != NULL) {
        next = current->next;
        current->next = NULL;

        if (sorted == NULL || comparaPaesi(&current->p, &sorted->p) < 0) {
            current->next = sorted;
            sorted = current;
        } else {
            Nodo *temp = sorted;
            while (temp->next != NULL && comparaPaesi(&current->p, &temp->next->p) >= 0) {
                temp = temp->next;
            }
            current->next = temp->next;
            temp->next = current;
        }

        current = next;
    }

    *l = sorted; // punta alla lista ordinata
}


void stampaLista(Lista l)
{
    while (l != NULL)
    {
        printf("%s, %d ori, %d argenti, %d bronzi\n", l->p.nome, l->p.oro, l->p.argento, l->p.bronzo);
        l = l->next;
    }
}