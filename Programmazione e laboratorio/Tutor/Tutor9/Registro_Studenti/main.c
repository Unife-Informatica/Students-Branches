#include <stdio.h>
#include "registro.h"
int main(){
    int scelta;
    Registro r;
    Studente s;
    azzeraRegistro(&r);
    do
    {
        printf("1->Visualizza gli studenti\n");
        printf("2->Aggiungi studente\n");
        printf("0->Esci\n");
        scanf("%d",&scelta);
        switch (scelta)
        {
        case 1:
            stampaRegistro(r);
            break;
        case 2: 
            nuovoStudente(&s);
            aggiungiStudente(&r,s);
            break;
        case 3:
            
            break;
        default:
            break;
        }
    } while (scelta!=0);
    
}