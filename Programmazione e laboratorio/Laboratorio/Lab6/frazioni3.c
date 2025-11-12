#include <stdio.h>
typedef struct{
    int num;
    int den;
} Frazione;
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
int num(Frazione f){ return f.num;}
int dem(Frazione f){ return f.den;}
Frazione frazione(int n,int d){
    frazione f;
    m=mcd(num(f),den(f));
    f.num =n/m;
    f.den=d/m;
    return f;
}
Frazione leggiFrazione(){
    int n,d;
    scanf("%d%d",&n,&d);
    return frazione(n,d);

}
void stampaFrazionaria(Frazione f){
    printf("%d/%d",num(f),den(f));
}
void stampaDecimale(Frazione f){
    printf("%f",(float)num(f)/den(f));
}
Frazione somma(Frazione f,Frazione g){
    return frazione(num(f1)*den(f2)+num(f2)*den(f1),den(f1)*den(f2));
}
Frazione opposto(Frazione f,Frazione g){
    return frazione(-num(f),den(f));
}
Frazione differenza(Frazione f1,Frazione f2){
    return somma(f1,opposto(f2));
}
Frazione prodotto(Frazion f1,Frazione f2){
    return frazione(num(f1)*num(f2),den(f1)*den(f2));
}
Frazione inverso(Frazione f){
    return frazione(den(f),num(f));
}
Frazione quoziente(Frazione f1,Frazione f2){
    return prodotto(f1,inverso(f2));
}
int main(){
    Frazione f1,f2;
    f1=frazione(36,60);
    f2=leggiFrazione();
    stampaFrazionaria(prodotto(f1,f2));
    stampaFrazionaria(somma(f1,f2));
    stampaFrazionaria(differenza(f1,f2));
    stampaDecimale(f1);
    
}