#include<stdio.h>
int main(){
    int a[5],p1=1,p2=1,t;
    printf("Inserisci 5 numeri");
    for (int i = 0; i < 5; i++)
    {
        scanf("%d",&a[i]);
    }
    for (int i = 0; i < 5; i++)
    {
        p1=p1*a[i];
    }
    t=a[0];
    a[0]=a[4];
    a[4]=t;
    for (int i = 0; i < 5; i++)
    {
        p2=p2*a[i];
    }
    printf("%d",p2);
    
    

    
}