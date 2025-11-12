#include<stdio.h>

float va(float v){
    if(v>0){
        return v;
    }else
        return -v;
}
float radice(float r){
    float a,b,x;
    x=1;
    while(va(x*x-r)/r>1e-5){
        a=(r-x*x)/(2*x);
        b=x+a;
        x=b-a*a/(2*b);
    }
    return x;
}
int main(){
    int a,b;
    int maggiore, minore;
    float c=0.0;
    printf("Inserisci due numeri:");
    scanf("%d%d",&a, &b);
    if(a<=b){
        minore = a;
        maggiore = b;
    } else{
        minore = b;
        maggiore = a;
    }
    for(int i=minore;i<=maggiore;i++){
        c+=radice((float)i);
    }
    printf("%f\n", c);

}