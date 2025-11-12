#include <stdio.h>
#include <stdlib.h>
#include "gestione_file.h"
#define DIM 100

void leggiFile(Prodotto *prodotti,int *contProd){
    FILE *pf;
    *contProd=0;
    pf=fopen("inventario.txt","r");
    if(pf==NULL){
        printf("Errore apertura file\n");
        exit(1);
    }
    while (fscanf(pf,"%d%s%d%f",&prodotti[*contProd].ID,prodotti[*contProd].nome,&prodotti[*contProd].quantita,&prodotti[*contProd].prezzo)==4)
    {
        (*contProd)++;
        if(*contProd>=DIM){
            printf("Raggiunto il massimo di prodotti supportati");
            break;
        }
    }
    fclose(pf);
}
void aggiungiProdotto(Prodotto *prodotti,int *contProd){
    Prodotto nuovoProdotto;
    FILE *pf;
    int n,i;
    pf=fopen("inventario.txt","a");
    if(pf==NULL){
        printf("Errore nell'apertura del file");
        exit(1);
    }
    printf("Quanti prodotti vuoi aggiungere?: ");
    scanf("%d",&n);
    printf("\n");
    for (i = 0; i < n; i++)
    {
        printf("%d PRODOTTO\n", i);
        printf("Inserisci l'ID: ");
        scanf("%d",&nuovoProdotto.ID);
        printf("\n");
        printf("Inserisci il nome: ");
        scanf("%s",nuovoProdotto.nome);
        printf("\n");
        printf("Inserisci la quantita': ");
        scanf("%d",&nuovoProdotto.quantita);
        printf("\n");
        printf("Inserisci il prezzo: ");
        scanf("%f",&nuovoProdotto.prezzo);
        printf("\n");
        fprintf(pf,"%d %s %d %f",nuovoProdotto.ID,nuovoProdotto.nome,nuovoProdotto.quantita,nuovoProdotto.prezzo);
    }
    fclose(pf);
    if(i==1)
        printf("Al file e' stato aggiunto %d prodotto\n",i);
    if(i>=2)
        printf("Al file sono stati aggiunti %d prodotti\n",i);
    printf("\n");
}
void aggiornaFile(Prodotto *prodotti,int *contProd){
    FILE *pf;
    pf=fopen("inventario.txt","wt");
    if(pf==NULL){
        printf("Errore apertura file\n");
        exit(1);
    }
    for (int i = 0; i < *contProd; i++)
    {
        fprintf(pf,"%d %s %d %f\n",prodotti[i].ID,prodotti[i].nome,prodotti[i].quantita,prodotti[i].prezzo);   
    }
    fclose(pf);
}