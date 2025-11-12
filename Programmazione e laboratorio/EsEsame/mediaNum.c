#include <stdio.h>
int media(int a, int b){
    return (a+b)/2;
}
int main(){
    int a,b;
    printf("Inserisci due numeri: ");
    scanf("%d%d", &a, &b);
    int risultato=media(a,b);
    printf("%d", risultato);
}