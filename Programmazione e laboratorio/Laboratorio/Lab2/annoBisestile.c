#include<stdio.h>
int main(){
    int anno;
    printf("Inserire anno: ");
    scanf("%d", &anno);
    if(anno%4==0&&anno%100!=0||anno%400==0){
        printf("Il %d e' bisestile\n", anno);
    }else
        printf("Il %d non e' bisestile\n", anno);
    
}