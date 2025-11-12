#include <stdio.h>
#include "orario.h"
int main(){
    int scelta;
    char orario[RIGHE][COLONNE][SIZE];
    char g[15];
    char o[10];
    char lezione[50];
    inizOrario(orario);
    do
    {
        printf("1->Stampa orario completo\n");
        printf("2->Stampa l'orario di un solo giorno\n");
        printf("3->Modifica l'orario\n");
        printf("0->Esci\n");
        scanf("%d",&scelta);
        switch (scelta)
        {
        case 1:
            stampaOrario(orario);
            break;
        case 2:
            printf("Inserisci il nome del giorno(Es. Lunedi'):\n");
            scanf("%s",g);
            stampaOrarioG(orario,g);
            break;
        case 3:
            printf("Inserisci il nome del giorno(Es. Lunedi'):\n");
            scanf("%s",g);
            printf("Inserisci l'orario(9-11 11-13 14-16 16-18):\n");
            scanf("%s",o);
            printf("Inserisci il nome della lezione:\n");
            scanf("%s",lezione);
            modifica(orario,g,o,lezione);
            break;
        default:
            break;
        }
    } while (scelta!=0);
    
}