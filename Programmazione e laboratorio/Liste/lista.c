#include <stdio.h>
#include <stdlib.h>
#include <mm_malloc.h>
typedef int Dato;
typedef struct nodo{
    Dato valore;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void popolaLista(Lista *pl,int n){
    int numero;
    for (int i = 0; i < n; i++)
    {
        printf("Inserisci il %s numero:",i+1);
        scanf("%d",&numero);
        (*pl)=(Nodo*)malloc(sizeof(Nodo));
        (*pl)->valore=numero;
        (*pl)->next=NULL;
        pl=&(*pl)->next;
    }
     

void azzera(Lista *pl) {
    while (*pl != NULL) {
        (*pl)->valore = 0;
        *pl = (*pl)->next;
    }
}
int main(){
    Lista pl=NULL;
    int n;
    printf("Quanti numeri vuoi inserire: ");
    scanf("%d",&n);
    azzera(&pl);
}