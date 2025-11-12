#include <stdio.h>
#include <mm_malloc.h>
#include <time.h>
#include <stdlib.h>
typedef int Dato;
typedef struct nodo{
    Dato dato;
    struct nodo *next;
}Nodo;

typedef Nodo *Lista;
int rnd(){
    srand(time(NULL));
    int min =1,max=10;
    return min+rand()%(max-min+1);
}
void listaOrdinata(Lista* pl) {
  int a[] = {2, 3, 4, 5, 7, 8, 12, 15, 21, 24};
  for (int i = 0; i < rnd(); i++) {
    (*pl) = (Nodo*)malloc(sizeof(Nodo));
    (*pl)->dato = a[i];
    (*pl)->next = NULL;
    pl = &(*pl)->next;
  }
}
int contaElementi(Lista l){
    int cont=0;
    while (l!=NULL)
    {
        l=l->next;
        cont++;
    }
    return cont;
    
}
int main(){
    Lista l;
    int n,contaElem;
    listaOrdinata(&l);
    contaElem=contaElementi(l);
    printf("Numero di elementi: %d",contaElem);
    
}