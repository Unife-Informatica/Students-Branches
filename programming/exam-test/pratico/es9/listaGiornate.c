#include <stdio.h>
#include <stdlib.h>

#include "listaGiornate.h"

void initList(List *l) {
    *l = NULL;
}

void addHead(List *l, Worker w) {
    Node *tmp;

    tmp = (Node *)malloc(sizeof(Node));
    tmp->w = w;
    tmp->next = *l;
    *l = tmp;
}

void update(List *l, Record r) {
    while (*l != NULL && ((*l)->w.month < r.month || ((*l)->w.month == r.month && (*l)->w.day < r.day))) {
        l = &(*l)->next;
    }
    if (*l == NULL || (*l)->w.day != r.day || (*l)->w.month != r.month) {
        Worker w;
        w.day = r.day;
        w.month = r.month;
        w.total = 0.0;

        addHead(l, w);
    }
    (*l)->w.total += r.hours;
}

void printList(List l) {
    while(l) {
        printf("%d/%d\t%.2f\n", l->w.day, l->w.month, l->w.total);
        l = l->next;
    }
}