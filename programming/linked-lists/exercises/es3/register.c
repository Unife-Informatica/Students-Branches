#include <malloc.h>
#include <string.h>
#include <stdlib.h>
#include "register.h"

void addBook(Register *r, Data d)
{
    // Creazione di un nuovo nodo
    Node *newNode = (Node *)malloc(sizeof(Node)); // restituisce puntatore di tipo Node
    if (newNode == NULL)
    {
        printf("Errore di allocazione memoria!\n");
        return;
    }

    // Assegna il dato al nodo
    newNode->d = d;

    // Il nuovo nodo punta al nodo precedente (se esiste), quindi aggiorniamo la testa
    newNode->next = *r;

    // Aggiorna la testa della lista
    *r = newNode;
}

void printRegister(Register r)
{
    if (r == NULL)
    {
        printf("Il registro è vuoto.\n");
        return;
    }

    // Stampa tutti i libri nel registro
    while (r != NULL)
    {
        printf("%s\t%s\t%d\n", r->d.author, r->d.name, r->d.year);
        r = r->next;
    }
}

Data searchBook(Register r, char name[])
{
    if (r == NULL)
    {
        printf("Il registro è vuoto.\n");
        exit(1);
    }

    while (r != NULL)
    {
        if (strcmp(r->d.name, name) == 1)
        {
            return r->d;
        }
        r = r->next;
    }
}

void deleteBook(Register *r, char *name)
{
    if (r == NULL)
    {
        printf("Il registro è vuoto.\n");
        exit(1);
    }

}