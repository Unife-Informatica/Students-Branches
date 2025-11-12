#include <stdio.h>
#include "gestione_file.h"
#include "utils.h"
#define DIM 100

int main(){
    Prodotto prodotti[DIM];
    int menu,cProd,contProd=0;
    leggiFile(prodotti,&contProd);
    do
    {
        printf("MENU GENERALE\n");
        //Menu generale 
        printf("1->Cerca un prodotto\n");
        printf("2->Aggiungi prodotto\n");
        printf("3->Modifica prodotto\n");
        printf("4->Visualizza prodotti\n");
        printf("0->Esci\n");
        printf("Scelta: ");
        scanf("%d",&menu);
        printf("\n");
        // Switch menu generale
        switch (menu)
        {
        case 1:
            do
            {
                printf("MENU PER LA RICERCA DI UN PRODOTTO\n");
                //Menu per la ricerca
                printf("1->Cerca per id\n");
                printf("2->Cerca per nome\n");
                printf("3->Cerca per quantita'\n");
                printf("4->Cerca per prezzo\n");
                printf("0->Esci dalla ricerca\n");
                printf("Scelta: ");
                scanf("%d",&cProd);
                printf("\n");
                //switch per menu di ricerca
                switch (cProd)
                {
                case 1:
                    cercaID(prodotti,&contProd);
                    break;
                case 2:
                    cercaNome(prodotti,&contProd);
                    break;
                case 3:
                    cercaQuant(prodotti,&contProd);
                    break;
                case 4:
                    cercaPrezzo(prodotti,&contProd);
                    break;
                default:
                    break;
                }
            } while (cProd!=0);
            
            break;
        case 2:
            aggiungiProdotto(prodotti,&contProd);
            leggiFile(prodotti,&contProd);
            break;
        case 3:
            visualizzaProd(prodotti,&contProd);
            modificaProd(prodotti,&contProd);
            aggiornaFile(prodotti,&contProd);
            break;
        case 4:
            visualizzaProd(prodotti,&contProd);
            break;
        
        default:
            break;
        }
    } while (menu!=0);
    
}