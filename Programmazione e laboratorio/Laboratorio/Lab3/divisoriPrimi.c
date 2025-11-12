#include <stdio.h>

int main() {
    int num,div_cand,j,i;
    printf("Inserisci numero: ");
    scanf("%d",&num);
    for(int candidato=2;candidato<=num;candidato++){
        if(num%candidato==0){
            div_cand=0;
            for ( i = 2; i < candidato; i++)
            {
                if(candidato%i==0){
                    div_cand++;
                }
            }
            if(div_cand==0){
                printf("%d ",candidato);
            }
        }
    }
    
}
