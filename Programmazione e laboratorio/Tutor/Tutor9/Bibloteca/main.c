#include <stdio.h>
#include "biblioteca.h"
int main(){
    Biblioteca l;
    Libro b;
    char titolo[30];
    int scelta;
    inizializza_biblioteca(&l);
    do
    {
        printf("Biblioteca\n");
        printf("1->Visualizza tutti i libri\n");
        printf("2->Aggiungi libro\n");
        printf("3->Ricerca di un libro\n");
        printf("0->Esci\n");
        scanf("%d",&scelta);
        switch (scelta)
        {
        case 1:
            stampa_biblioteca(l);
            break;
        case 2:
            inserimento_libro(&b);
            inserimento_biblioteca(&l,b);
            break;
        case 3:
            printf("Inserisci il titolo da ricercare:\n");
            scanf("%s",titolo);
            ricerca_libro(l,titolo);
            break;
        default:
            break;
        }
    } while (scelta!=0);
    
}