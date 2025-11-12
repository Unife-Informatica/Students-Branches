#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "gestione_inventario.h"
#define DIM 100
void cercaID(Prodotto *prodotti,int *contProd){
    int ID;
    printf("Inserisci ID: ");
    scanf("%d",&ID);
    printf("\n");
    for (int i = 0; i < *contProd; i++){
        if(prodotti[i].ID==ID){
            printf("|Prodotto: %d %s %d %.2f\n",prodotti[i].ID,prodotti[i].nome,prodotti[i].quantita,prodotti[i].prezzo);
        }
    }
    printf("\n");
    
}
void cercaNome(Prodotto *prodotti,int *contProd){
    char nome[20];
    printf("Inserisci Nome: ");
    scanf("%s",nome);
    printf("\n");
    for (int i = 0; i < *contProd; i++){
        if(strstr(prodotti[i].nome,nome)){
            printf("|Prodotto: %d %s %d %.2f\n",prodotti[i].ID,prodotti[i].nome,prodotti[i].quantita,prodotti[i].prezzo);
        }
    }
    printf("\n");
}
void cercaQuant(Prodotto *prodotti,int *contProd){
    int quantita;
    printf("Inserisci Quantita': ");
    scanf("%d",&quantita);
    printf("\n");
    for (int i = 0; i < *contProd; i++){
        if(prodotti[i].quantita==quantita){
            printf("|Prodotto: %d %s %d %.2f\n",prodotti[i].ID,prodotti[i].nome,prodotti[i].quantita,prodotti[i].prezzo);
        }
    }
    printf("\n");
    
}
void cercaPrezzo(Prodotto *prodotti,int *contProd){
    int prezzo;
    printf("Inserisci Prezzo: ");
    scanf("%d",&prezzo);
    printf("\n");
    for (int i = 0; i < *contProd; i++){
        if(prodotti[i].prezzo==prezzo){
            printf("|Prodotto: %d %s %d %.2f\n",prodotti[i].ID,prodotti[i].nome,prodotti[i].quantita,prodotti[i].prezzo);
        }
    }
    printf("\n");
    
}
void modificaProd(Prodotto *prodotti,int *contProd){
    int ID,scelta,trovato=0;
    printf("Inserisci l'ID del prodotto da modificare: ");
    scanf("%d",&ID);
    printf("\n");
    for (int i = 0; i < *contProd; i++)
    {
        if(prodotti[i].ID==ID){
            trovato=1;
            do
            {
                printf("MENU DI MODIFICA PRODOTTO\n");
                printf("1->Modifica ID\n");
                printf("2->Modifica Nome\n");
                printf("3->Modifica Quantita\n");
                printf("4->Modifica Prezzo\n");
                printf("0->Esci per modificare\n");
                printf("Inserisci scelta:");
                scanf("%d",&scelta);
                printf("\n");
                switch (scelta)
                {
                case 1:
                    printf("Inserisci nuovo id: ");
                    scanf("%d",&prodotti[i].ID);
                    break;
                case 2:
                    printf("Inserisci nuovo nome: ");
                    scanf("%s",prodotti[i].nome);
                    break;
                case 3:
                    printf("Inserisci nuova quantita': ");
                    scanf("%d",&prodotti[i].quantita);
                    break;
                case 4:
                    printf("Inserisci nuovo prezzo: ");
                    scanf("%f",&prodotti[i].prezzo);
                    break;
                default:
                    break;
                }
                
            } while (scelta!=0);   
        }
        if(trovato){
            break;
        }
    }    
}
void visualizzaProd(Prodotto *prodotti,int *contProd){
    printf("MAGAZZINO COMPLETO\n");
    printf("\n");
    for(int i=0;i<*contProd;i++){
        printf("|Prodotto: %d %s %d %.2f\n",prodotti[i].ID,prodotti[i].nome,prodotti[i].quantita,prodotti[i].prezzo);
    }
    printf("\n");
}