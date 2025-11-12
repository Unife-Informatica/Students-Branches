#include<stdio.h>

float giornoGiuliano(int g,int m, int a){
    int JD;
    int N0,N1,N2,N3;
    
    N0=(m-14)/12;
    N1=1461*(a+4800+N0)/4;
    N2=367*(m-2-12*N0)/12;
    N3=3*(a+4900+N0)/400;
    JD=N1+N2-N3+g-32075;
    return JD;
}
int main(){
    int G,M,A;
    int gS;
    int D1,D2;
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

    D1=giornoGiuliano(G,M,A);

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

    D2=giornoGiuliano(G,M,A);
    printf("%d",D2);
    printf("%d\n", D2-D1);

    gS=D2%7;
    switch (gS)
    {
    case 0:
        printf("Lun");
        break;
    case 1:
        printf("Mart");
        break;
    case 2:
        printf("Merc");
        break;
    case 3:
        printf("Giov");
        break;
    case 4:
        printf("Ven");
        break;
    case 5:
        printf("Sab");
        break;
    case 6:
        printf("Dom");
        break;
    default:
        break;
    }

}