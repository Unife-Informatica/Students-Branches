#include <mm_malloc.h>
#include <stdio.h>
int n;//Variabile globale
int main(){
    int *pa;
    int i;//Variabile automatica
    pa=(int*)malloc(sizeof(int));//Allocazione
    *pa = 7;// "Variabile" dinamica
    printf("%d\n",*pa);
    free(pa);//Deallocazione
}