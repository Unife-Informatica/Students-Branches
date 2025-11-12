#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "matrici.h"
int rnd(){
    int min=1,max=20;
    return min+rand()%(max-min+1);
}
void popolaMatrice(int m[3][3]){
    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            m[i][j]=rnd();
        }
    }
}
void sommaMatrici(int a[3][3],int b[3][3],int c[3][3]){
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            c[i][j]=a[i][j]+b[i][j];
        }
    }
}
void stampaMatrice(int m[3][3]){
    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            printf("%d ",m[i][j]);
        }
        printf("\n");
    }
}