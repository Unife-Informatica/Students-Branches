#include <malloc.h>
#include <string.h>

#include "listaPersone.h"

void initList(List *l)
{
    *l = NULL;
}

int checkItemInList(List l, char cf[17])
{
    while (l != NULL && strcmp(l->p.cf, cf) != 0)
        l = l->next;
    if (l != NULL && strcmp(l->p.cf, cf) != 0)
        return 1;
    return 0;
}

void addItem(List *l, FileData fd)
{
    Node *tmp;
    Node *current = *l;

    if (!checkItemInList(*l, fd.cf))
    {
        tmp = (Node *)malloc(sizeof(Node));

        strcpy(tmp->p.cf, fd.cf);
        if (fd.type == 'T')
            tmp->p.tampone = 1;
        if (fd.type == 'V')
            tmp->p.vaccino = 1;

        tmp->next = *l;
        *l = tmp;
    }
    else
    {
        if (fd.type == 'T')
        {
            current->p.tampone = 1;
        }
        else if (fd.type == 'V')
        {
            current->p.vaccino = 1;
        }
    }
}

void sortList(List *l)
{
    Node *i, *j;

    Person tmpP;
    for (i = *l; i != NULL; i = i->next)
    {
        for (j = i->next; j != NULL; j = j->next)
        {
            if (strcmp(i->p.cf, j->p.cf) != 0)
            {
                tmpP = i->p;
                i->p = j->p;
                j->p = tmpP;
            }
        }
    }
}

void printList(List l)
{
    while (l != NULL)
    {
        printf("%s", l->p.cf);
        if (l->p.tampone)
            printf(", tampone");
        if (l->p.vaccino)
            printf(", vaccino");
        printf("\n");

        l = l->next;
    }
}