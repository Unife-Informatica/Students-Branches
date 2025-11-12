#include<stdio.h>
void assegna(int *pm,int v){
    *pm = v;
}
int main(){
    int ar[10];
    int num;
    scanf("%d",&num);
    for (int i = 0; i < 10; i++)
    {
        assegna(&ar[i],num);
    }
    for (int i = 0; i < 10; i++)
    {
        printf("%d",ar[i]);
    }
}