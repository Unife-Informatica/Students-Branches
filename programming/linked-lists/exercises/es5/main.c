#include <stdio.h>
#include <malloc.h>

typedef int Data;

typedef struct ele
{
    Data value;
    struct ele *next;
} Node;

typedef Node *List;

void headInsert(List *l, Data v)
{
    Node *new;

    new = (Node *)malloc(sizeof(Node));

    new->value = v;
    new->next = *l;
    *l = new;
}

void nullList(List l) {
    while(l != NULL) {
        l->value = 0;
        l = l->next;
    }
}

void printList(List l) {
    while(l != NULL) {
        printf("%d\n", l->value);
        l = l->next;
    }
}

int main()
{
    List l = NULL;

    headInsert(&l, 5);
    headInsert(&l, 2);
    headInsert(&l, 4);
    headInsert(&l, 6);

    nullList(l);

    printList(l);
}