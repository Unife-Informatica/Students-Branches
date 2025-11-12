#include "listaUtenti.h"
void iniz_lista(Lista *pl){
    *pl=NULL;
}
void ins_testa(Lista *pl,Utente u){
    Nodo *aux=malloc(sizeof(Nodo));
    aux->dato=u;
    aux->next=*pl;
    *pl=aux;
}
void ins_ordinato(Lista *pl,Record r){
    Utente u;
    strcpy(u.numero_tel,r.numero_tel);
    u.piano_tarif=r.piano_tarif;
    u.credito_residuo=r.credito_residuo;
    while((*pl)!=NULL&&strcmp((*pl)->dato.numero_tel,r.numero_tel)<0){
        pl=&(*pl)->next;
    }
    ins_testa(pl,u);
}
void controllo_chiamata(Lista *pl,char numeroTel[],int secChiamata){
    while(*pl!=NULL){
        if(strcmp((*pl)->dato.numero_tel,numeroTel)==0){
            int scatti = 0;
            float costo = 0.0;
            switch ((*pl)->dato.piano_tarif){
            case 'A':
                scatti=secChiamata/60;
                if(secChiamata%60>0){
                    scatti+=1;
                }
                costo =0.15+(scatti*0.08);
                if((*pl)->dato.credito_residuo>=costo){
                    (*pl)->dato.credito_residuo-=costo;
                }else{
                    printf("Credito insufficiente per il numero %s\n",numeroTel);
                }
                break;
            case 'B':
                costo=(0.12/60)*secChiamata;
                if((*pl)->dato.credito_residuo>=costo){
                    (*pl)->dato.credito_residuo-=costo;
                }else{
                    printf("Credito insufficiente per il numero %s\n",numeroTel);
                }
                break;
            default:
                printf("Piano tariffario non valido per il numero");
                break;
            }
        }
        pl=&(*pl)->next;
    }
}

void stampa_lista(Lista l){
    while(l!=NULL){
        printf("%s %.2f\n",l->dato.numero_tel,l->dato.credito_residuo);
        l=l->next;
    }
}