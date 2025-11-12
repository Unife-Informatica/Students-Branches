#include <stdio.h>
typedef struct{
    int numeratore;
    int denominatore;
}Frazione;
Frazione frazione(int n,int d){
    Frazione f;
    f.numeratore=n;
    f.denominatore=d;
    return f;
}
Frazione leggiFrazione(){
    int n,d;
    printf("Inserisci numeratore e denominatore: ");
    scanf("%d%d",&n,&
    
    d);
    return frazione(n,d);
} 
