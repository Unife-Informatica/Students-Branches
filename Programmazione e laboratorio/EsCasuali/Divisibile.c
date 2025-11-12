#include<stdio.h>
int divisibile(int a, int b){
    int j;
    while(a>0){
        for(j=0; a>1&&j<b-1;j++){
            a--;
            
        }
        a--;
    }
    return a==0 && j==b-1;
        

}
int main(){
    int a,i;
    printf("Inserisci numeratore: ");
    scanf("%d", &a);
    for(i=1;i<=a;i++){
        if(divisibile(a,i))
            printf("%d ",i);
        
    }
    printf("\n");
    return 0;
    
    
}