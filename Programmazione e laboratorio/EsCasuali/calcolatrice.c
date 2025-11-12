#include<stdio.h>   
int somma(int a,int b){
    return  a+b;
}
int sottrazione(int a, int b){
    return a-b;
}
int moltiplicazione(int a, int b){
    return a*b;
}
int divisione(int a, int b){
    return a/b;
}
int main(){
    int a,b;
    printf("Inserire due numeri: ");
    scanf("%d%d",&a,&b);
    printf("%d\n", somma(a,b));
    printf("%d\n", sottrazione(a,b));
    printf("%d\n", moltiplicazione(a,b));
    printf("%d", divisione(a,b));

}