#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "file.h"
int main(int argc,char *argv[]){
    FILE *pf;
    Registro r;
    int scelta;
    leggi_file(pf,&r,argv);
    do
    {
        printf("1->Stampa registro\n");
        printf("2->Inserisci in un file di testo\n");
        printf("0->Esci");
        scanf("%d",&scelta);
        switch (scelta)
        {
        case 1:
            stampa_registro(r);
            break;
        case 2:

            break;
        default:
            break;
        }           
    } while (scelta!=0);
    
}