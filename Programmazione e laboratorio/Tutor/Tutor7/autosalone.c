#include<stdio.h>
#include <string.h>
#define DIM 50
typedef struct{
    char marca[DIM];
    int cilindrata;
    int anno;
    char nome[DIM];
    char cognome[DIM];
}Automobile;
void inserisciAuto(Automobile a[],int *cont){
    printf("Inserimento auto\n");
    printf("Inserisci marca: ");
    scanf("%s",a[*cont].marca);
    printf("\n");
    do{
        printf("Inserisci cilindrata: ");
        scanf("%d",&a[*cont].cilindrata);
        printf("\n");
    }while(a[*cont].cilindrata<800||a[*cont].cilindrata>2500);
    do{
        printf("Inserisci anno immatricolazione: ");
        scanf("%d",&a[*cont].anno);
        printf("\n");
    }while(a[*cont].anno<2000||a[*cont].anno>2023);
    printf("Inserisci nome proprietario: ");
    scanf("%s",a[*cont].nome);
    printf("\n");
    printf("Inserisci cognome proprietario: ");
    scanf("%s",a[*cont].cognome);
    printf("\n");
    (*cont)++;
}
void cercaMarca(Automobile a[],int cont){
    char temp[DIM];
    printf("Inserisci marca: ");
    scanf("%s",temp);
    for (int i = 0; i < cont; i++){
        if(!strcmp(temp,a[i].marca)){
            printf("Marca: %s\n",a[i].marca);
            printf("Cilindrata: %d\n",a[i].cilindrata);
            printf("Anno immatricolazione: %d\n",a[i].anno);
            printf("Nome: %s\n",a[i].nome);
            printf("Cognome: %s\n",a[i].cognome);
        }
    }
    
}
void cercaAnno(Automobile a[],int cont){
    int anno;
    printf("Inserisci anno di immatricolazione: ");
    scanf("%d",&anno);
    for (int i = 0; i < cont; i++){
        if(anno==a[i].anno){
            printf("Marca: %s\n",a[i].marca);
            printf("Cilindrata: %d\n",a[i].cilindrata);
            printf("Anno immatricolazione: %d\n",a[i].anno);
            printf("Nome: %s\n",a[i].nome);
            printf("Cognome: %s\n",a[i].cognome);
        }
    }
}
void cercaCilindrata(Automobile a[],int cont){
    int cilindrata;
    printf("Inserisci cilindrata: ");
    scanf("%d",&cilindrata);
    for (int i = 0; i < cont; i++)
    {
        if(a[i].cilindrata<=cilindrata){
            printf("Marca: %s\n",a[i].marca);
            printf("Cilindrata: %d\n",a[i].cilindrata);
            printf("Anno immatricolazione: %d\n",a[i].anno);
            printf("Nome: %s\n",a[i].nome);
            printf("Cognome: %s\n",a[i].cognome);
        }
    }
    
}
int main(){
    Automobile autosalone[5];
    int scelta, cont=0;
    do{
        printf("1-> Inserisci auto\n");
        printf("2-> Ricerca tramite marca\n");
        printf("3-> Ricerca tramite anno\n");
        printf("4-> Ricerca decrescente tramite cilindrata\n");
        printf("0-> Esci\n");
        scanf("%d",&scelta);
        switch (scelta)
    {
    case 1:
        inserisciAuto(autosalone,&cont);
        break;
    case 2:
        cercaMarca(autosalone,cont);
        break;
    case 3:
        cercaAnno(autosalone,cont);
        break;
    case 4:
        cercaCilindrata(autosalone,cont);
        break;
    default:
        break;
    }
    }while(scelta!=0);
    
}