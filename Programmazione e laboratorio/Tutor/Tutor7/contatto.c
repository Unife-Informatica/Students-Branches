#include <stdio.h>
#include <string.h>
#define DIM 50
typedef struct
{
    char nome[DIM];
    char cognome[DIM];
    char numero[DIM];
}Contatto;
void stampaRubrica(Contatto rubrica[],int cont){
    for (int i = 0; i < cont; i++)
    {
        printf("%d|Nome: %s\n",i+1,rubrica[i].nome);
        printf("%d|Nome: %s\n",i+1,rubrica[i].cognome);
        printf("%d|Nome: %s\n",i+1,rubrica[i].numero);
    }
    
}
void inserisciContatto(Contatto rubrica[],int *cont){
    printf("Inserisci il nuovo contatto\n");
    printf("Nome: ");
    scanf("%s",rubrica[*cont].nome);
    printf("\n");
    printf("Cognome: ");
    scanf("%s",rubrica[*cont].cognome);
    printf("\n");
    printf("Numero di telefono: ");
    scanf("%s",rubrica[*cont].numero);
    printf("\n");
    (*cont)++;
}
void cercaContatto(Contatto rubrica[],int cont){
    char nome[DIM];
    printf("Inserisci il nome del contatto");
    scanf("%s",nome);
    for (int i = 0; i < cont; i++)
    {
        if(!strcmp(nome,rubrica[i].nome)){
            printf("%d|Nome: %s\n",i+1,rubrica[i].nome);
            printf("%d|Nome: %s\n",i+1,rubrica[i].cognome);
            printf("%d|Nome: %s\n",i+1,rubrica[i].numero);
        }
    }
    
}
int main(){
    Contatto rubrica[20];
    int scelta, cont=0;
    do{
        printf("1->Stampa l'intera rubrica\n");
        printf("2-> Inserisci un nuovo contatto in rubrica\n");
        printf("3->Cerca un contatto in rubrica\n");
        printf("0->Esci\n");
        scanf("%d",&scelta);
        switch (scelta)
    {
    case 1:
        stampaRubrica(rubrica,cont);
        break;
    case 2:
        inserisciContatto(rubrica,&cont);
        break;
    case 3:
        cercaContatto(rubrica,cont);
        break;
    default:
        break;
    }
    }while(scelta!=0);
}