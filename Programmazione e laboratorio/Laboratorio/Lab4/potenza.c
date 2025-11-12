#include<stdio.h>

float potenza(int base,int esp){
    int cont;
    float prod = 1;
    if(esp>0){
        for(cont=0;cont<esp;cont++){
            prod*=base;
        }
        return prod;
    }
    if(esp<0){
        esp=-esp;
        for (int i = 0; i < esp; i++){
            prod*=base;
        }
        return 1/prod;
        
    }
    return 1;
}

int main(){
    int b,e;
    float risultato;
    printf("Inserisci numero: ");
    scanf("%d%d",&b,&e);
    risultato = potenza(b,e);
    printf("%f",risultato);
}

