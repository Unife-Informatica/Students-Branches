#include <stdio.h>
#include <string.h>
int main(){
    struct 
    {
        char nome[20];
        char cognome[23];
        int eta;
    }p1,p2,p[20];
    strcpy(p1.nome,"Mario");
    //strcpy(p.cognome,"Rossi");
    scanf("%s",p1.cognome);
    //p.eta=28;
    scanf("%d",&p1.eta);
    strcpy(p2.nome,"Arturo");
    //strcpy(p.cognome,"Rossi");
    scanf("%s",p2.cognome);
    //p.eta=28;
    scanf("%d",&p2.eta);
    printf("%s %s %d\n",p1.nome,p1.cognome,p1.eta);
    printf("%s %s %d\n",p2.nome,p2.cognome,p2.eta);
    p[18].eta=28;
    
}