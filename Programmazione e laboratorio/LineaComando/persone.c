#include <stdio.h>
typedef struct{
    char cognome[31];
    char nome[31];
    char sesso;
    int anno;
}Persona;
int main(){
    Persona p;
    FILE *pf;
    pf=fopen("people.txt","rt");
    if(pf==NULL){
        printf("Non si apre il tuo file");
    }
    while (fscanf(pf,"%s %s %c %d",p.cognome,p.nome,&p.sesso,&p.anno)==4)
    {
        printf("%s %s %c %d\n",p.cognome,p.nome,p.sesso,p.anno);
    }
    

}