#include<stdio.h>
int main(){
    int G,M,A;
    float JD;
    float N0,N1,N2,N3;
    printf("Inserire Giorno: ");
    scanf("%d",&G);
    while(G>31){
        printf("|ERRORE|Inserire un giorno valido\n");
        printf("Inserire giorno: ");
        scanf("%d",&G);
    }
    printf("Inserire mese: ");
    scanf("%d", &M);
    while(M>12){
        printf("|ERRORE|Inserire un mese valido\n");
        printf("Inserire giorno: ");
        scanf("%d",&M);
    }
    printf("Inserire anno: ");
    scanf("%d", &A);

    N0=M-14/12;
    N1=1461*(A+4800+N0)/4;
    N2=367*(M-2-12*N0)/12;
    N3=3*(A+4900+N0)/400;
    JD=N1+N2-N3+G-32075;

    printf("%f",JD);
    
}