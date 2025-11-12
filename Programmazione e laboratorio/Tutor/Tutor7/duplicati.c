#include <stdio.h>
#include <string.h>
#define DIM 100
void eliminaLettere(char s1[],char s2[],int *cont){
    char s3[DIM];
    strcpy(s3,s1);
    for (int i = 0; i < strlen(s2); i++){
        *cont=0;
        char s3[DIM];
        strcpy(s3,s1);
        for (int j = 0; j < strlen(s3); j++){
            if(s2[i]!=s3[j]){
                s1[*cont]=s3[j];
                (*cont)++;
            }
        }
        
    }
    
}
int main(){
    char s1[DIM],s2[DIM];
    int cont=0;
    printf("Inserisci parola: ");
    scanf("%s",s1);
    printf("Inserisci lettere da eliminare: ");
    scanf("%s",s2);
    eliminaLettere(s1,s2,&cont);
    printf("%s",s1);
}
