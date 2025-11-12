#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "listaUtenti.h"

void nuovaLista(Lista *pl) { *pl = NULL; }

void insTesta(Lista *pl, Dato d)
{
  Nodo *aux = malloc(sizeof(Nodo));
  aux->dato = d;
  aux->next = *pl;
  *pl = aux;
}

void inserisciUtente(Lista *pl, CodiceFiscale cf)
{
  Dato d;
  strcpy(d.cf, cf);
  d.att[0] = 4;
  d.att[1] = 4;
  d.att[2] = 4;
  d.failed_check = 0;
  insTesta(pl, d);
}

void aggiorna(Lista *pl, CodiceFiscale cf, int attivita)
{
  while (*pl != NULL && strcmp((*pl)->dato.cf, cf) != 0)
    pl = &(*pl)->next;
  if (*pl != NULL && strcmp((*pl)->dato.cf, cf) == 0)
  {
    if ((*pl)->dato.failed_check <= DEACTIVATION)
    {
      if ((*pl)->dato.att[attivita - 1] < 1)
      {
        printf("Utente %s, attivita %d: accesso negato\n", (*pl)->dato.cf, attivita);
        (*pl)->dato.failed_check++;
      }
      else
      {
        (*pl)->dato.att[attivita - 1]--;
      }
    }
    else
    {
      printf("Carta di %s bloccata!\n", (*pl)->dato.cf);
    }
  }
}

void stampa(Lista l)
{
  while (l)
  {
    printf("Ingressi utente %s: %d %d %d\n", l->dato.cf, l->dato.att[0],
           l->dato.att[1], l->dato.att[2]);
    l = l->next;
  }
}