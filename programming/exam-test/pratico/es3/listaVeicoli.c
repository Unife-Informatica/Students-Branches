#include <malloc.h>
#include <string.h>
#include <stdio.h>

#include "listaVeicoli.h"

int checkList(Lista l, Sosta s)
{
    while (l != NULL && strcmp(l->s.targa, s.targa) != 0)
    {
        l = l->next;
    }
    if (l != NULL && strcmp(l->s.targa, s.targa) == 0)
        return 1;
    return 0;
}

void incrementa(Lista l, Sosta s)
{
    while (l != NULL && strcmp((l)->s.targa, s.targa) != 0)
    {
        (l) = (l)->next;
    }
    if ((l) != NULL && strcmp((l)->s.targa, s.targa) == 0)
        (l)->ingressi++;
}

void insTesta(Lista *l, Sosta s)
{
    Nodo *tmp;
    tmp = (Nodo *)malloc(sizeof(Nodo));

    if (checkList(*l, s) == 0)
    {
        tmp->s = s;
        tmp->ingressi = 1;
        tmp->price = 0.0;
        tmp->next = *l;
        *l = tmp;
    }
    else
    {
        incrementa(*l, s);
    }
}

void calcolaImporto(Lista l)
{
    while (l != NULL)
    {
        if (l->ingressi <= 5)
        {
            l->price = (float)l->ingressi * 2.00;
        }
        if (l->ingressi >= 6 && l->ingressi <= 10)
        {
            l->price = (float)l->ingressi * 1.90;
        }
        if (l->ingressi > 10)
        {
            l->price = (float)l->ingressi * 1.80;
        }

        l = l->next;
    }
}