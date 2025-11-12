#include<stdio.h>
double quadrato(double lato){
    return lato*4;
}
double cerchio(double diametro){
    double raggio;
    const double PI=3.1416;
    raggio=diametro/2;
    return PI*(raggio*raggio);
}
double triangolo(double lato){
    return lato*3;
}

int main(){
    double a;
    printf("Inserire numero reale: ");
    scanf("%lf", &a);
    double aQuadrato=quadrato(a);
    double aCerchio=cerchio(a);
    double aTriangolo=triangolo(a);
    printf("%f\n%f\n%f\n",aQuadrato, aCerchio, aTriangolo);
}