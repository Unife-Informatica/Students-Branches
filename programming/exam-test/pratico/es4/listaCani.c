#include <malloc.h>

#include "listaCani.h"

int checkItemInList(List l, Dog d)
{
    while (l != NULL && l->d.chip != d.chip)
        l = l->next;
    if (l != NULL && l->d.chip == d.chip)
        return 1;
    return 0;
}

void updateVaccine(List l, Dog d)
{
    while (l != NULL && l->d.chip != d.chip)
        l = l->next;
    if (l != NULL && l->d.chip == d.chip)
    {
        switch (d.type)
        {
        case 'C':
            l->f.cimurro = 1;
            break;
        case 'E':
            l->f.epatite = 1;
            break;
        case 'P':
            l->f.parvovirosi = 1;
            break;
        }
    }
}

void addItem(List *l, Dog d)
{
    Node *tmp;

    if (!checkItemInList(*l, d))
    {
        tmp = (Node *)malloc(sizeof(Node));
        tmp->d = d;
        switch (d.type)
        {
        case 'C':
            tmp->f.cimurro = 1;
            break;
        case 'E':
            tmp->f.epatite = 1;
            break;
        case 'P':
            tmp->f.parvovirosi = 1;
            break;
        }
        tmp->next = *l;
        *l = tmp;
    }
    else
    {
        updateVaccine(*l, d);
    }
}

void printList(List l)
{
    while (l != NULL)
    {
        printf("%d", l->d.chip);
        if (!(l->f.cimurro))
            printf(" cimurro");
        if (!(l->f.epatite))
            printf(" epatite");
        if (!(l->f.parvovirosi))
            printf(" parvovirosi");
        printf("\n");
        l = l->next;
    }
}

int countVaccines(Flags f)
{
    int count = 0;
    if (f.cimurro)
        count++;
    if (f.epatite)
        count++;
    if (f.parvovirosi)
        count++;
    return count;
}

void sortList(List *l)
{
    if (*l == NULL || (*l)->next == NULL)
    {
        return;
    }

    Node *i, *j;
    Dog tmpDog;
    Flags tmpFlags;

    for (i = *l; i != NULL; i = i->next)
    {
        for (j = i->next; j != NULL; j = j->next)
        {
            int vaccinesI = countVaccines(i->f);
            int vaccinesJ = countVaccines(j->f);
            if (vaccinesI < vaccinesJ || (vaccinesI == vaccinesJ && i->d.chip > j->d.chip))
            {
                tmpDog = i->d;
                tmpFlags = i->f;
                i->d = j->d;
                i->f = j->f;
                j->d = tmpDog;
                j->f = tmpFlags;
            }
        }
    }
}
