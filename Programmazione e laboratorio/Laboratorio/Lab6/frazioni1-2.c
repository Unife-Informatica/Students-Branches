#include <stdio.h> 
typedef struct
{
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
    scanf("%d%d",&n,&d);
    return frazione(n,d);
}
void stampaFrazione(Frazione f){
    printf("%d/%d\n",f.numeratore,f.denominatore);
}
void stampaDecimale(Frazione f){
    printf("%f\n",(float)f.numeratore/f.denominatore);
}
int main(){
    Frazione f1;
    f1 = leggiFrazione();
    stampaFrazione(f1);
    stampaDecimale(f1);
}