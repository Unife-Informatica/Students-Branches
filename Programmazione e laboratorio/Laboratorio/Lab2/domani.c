#include <stdio.h>
int main(){
    int giorno, mese, anno;
    int maxG,maxM;
    maxG=31;
    maxM=12;
    printf("Inserire data: ");
    scanf("%d%d%d", &giorno, &mese, &anno);
    if(mese==4||mese==6||mese==9||mese==10){
        maxG=30;
    }
    if(mese==2){
        maxG=28;
    }
    if(giorno>=maxG){
        mese++;
        giorno=1;
    }else if(mese>=maxM){
        anno++;
        mese=1;
    }else{
        giorno++;
    }
    
    printf("%d %d %d",giorno,mese,anno);
    
}