#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "matrici.h"
int main(){
    srand(time(NULL));
    int a[3][3];
    int b[3][3];
    int c[3][3];
    popolaMatrice(a);
    printf("Matrice a:\n");
    stampaMatrice(a);
    printf("\n");
    popolaMatrice(b);
    printf("Matrice b:\n");
    stampaMatrice(b);
    printf("\n");
    printf("Matrice a+b:\n");
    sommaMatrici(a,b,c);
    stampaMatrice(c);
    return 0;
}