#include <stdlib.h>
#include <malloc.h>

#include "listaEsami.h"

void listInit(List *l)
{
    *l = NULL;
}

void addItem(List *l, fileStudent s)
{
    Node *tmp;

    Node *current = *l;
    while (current != NULL && current->s.matricola != s.matricola) {
        current = current->next;
    }

    if (current == NULL) {
        tmp = (Node *)malloc(sizeof(Node));
        if (tmp == NULL) {
            printf("Errore di allocazione della memoria!\n");
            return;
        }

        tmp->s.matricola = s.matricola;
        tmp->s.pratic_score = (s.type == 'P') ? s.score : 0;
        tmp->s.theory_score = (s.type == 'T') ? s.score : 0;
        tmp->next = *l;
        *l = tmp;
    } else {
        if (s.type == 'T') {
            current->s.theory_score = s.score;
        } else if (s.type == 'P') {
            current->s.pratic_score = s.score;
        }
    }
}

void printList(List l)
{
    while (l != NULL) {
        printf("%d ", l->s.matricola);

        if (l->s.pratic_score >= 12 && l->s.theory_score >= 6) {
            int total_score = l->s.pratic_score + l->s.theory_score;
            if (total_score > 30) {
                printf("30 e lode");
            } else {
                printf("%d", total_score);
            }
        } else {
            printf("non superato");
        }

        printf("\n");

        l = l->next;
    }
}