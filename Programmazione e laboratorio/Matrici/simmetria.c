#include <stdio.h>
void lettura(int matrice[3][3]){
    for (int i = 0; i < 3; i++){
        for(int j=0;j<3;j++){
            printf("Elemento[%d][%d]: ",i,j);
            scanf("%d",&matrice[i][j]);
        }
    }
}
void stampa(int matrice[3][3]){
    for (int i = 0; i<3; i++){
        for (int j = 0; j<3; j++)
        {
            printf("%d",matrice[i][j]);
        }
        printf("\n");
        
    }
    
}
int main(){
    int matrice[3][3];
    lettura(matrice);
    stampa(matrice);
}