#include <stdio.h> 
typedef struct
{
    int numeratore;
    int denominatore;
}Frazione;
int mcd(int a,int b){
    while(a!=b){
        if(a>b){
            a=a-b;
        }else{
            b=b-a;
        }
    }
    return a;
}
Frazione frazione(int n,int d){
    Frazione f;
    int m = mcd(n,d);
    f.numeratore=n/m;
    f.denominatore=d/m;
    return f;
}
Frazione leggiFrazione(){
    int n,d;
    printf("Inserisci numeratore e denominatore: ");
    scanf("%d%d",&n,&d);
    return frazione(n,d);
}
Frazione somma(){
    
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
};