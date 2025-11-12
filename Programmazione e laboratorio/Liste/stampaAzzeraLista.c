#include <stdio.h>
typedef int Dato;//gli elementi sono int

typedef struct nodo{
    int dato;
    struct nodo *next;
}Nodo;

typedef Nodo *Lista;
void stampa(Lista l){
    Nodo *p; //oppure Lista p
    p=l;
    while(p!=NULL){
        printf("%d\n",p->dato);
        p=p->next;
    }
}
void azzera(Lista l){
    while (l!=NULL)
    {
        l->dato=0;
        l=l->next;
    }
    
}
int main(){
    Lista l;
    listaNonOrdinata(&l,4);
    stampa(l);
    azzera()
    // l e' una lista collegata con 4 elementi
    /*printf("%d\n",l->dato);
    printf("%d\n",l->next->dato);
    printf("%d\n",l->next->next->dato);*/
    
}