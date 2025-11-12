#include "listaUtenti.h"
void iniz_lista(Lista *pl){
    *pl=NULL;
}
void ins_testa(Lista *pl, Utente u){
    Nodo *aux =malloc(sizeof(Nodo));
    aux->dato=u;
    aux->next=*pl;
    *pl=aux;
}
void ins_ordinato(Lista *pl, Record r){
    Utente u;
    strcpy(u.codice_fiscale,r.codice_fiscale);
    u.attivita_1=4;
    u.attivita_2=4;
    u.attivita_3=4;
    u.cont_negati=0;
    u.blocco=1;
    while(*pl!=NULL){
        pl=&(*pl)->next;
    }
    ins_testa(pl,u);
}
void controllo_acccessi(Lista *pl,char c_fiscale[17],int attivita){
    while(*pl!=NULL){
        if(strcmp((*pl)->dato.codice_fiscale,c_fiscale)==0){
            switch(attivita){
            case 1:
                if((*pl)->dato.blocco!=0){
                    if((*pl)->dato.attivita_1>0){
                        (*pl)->dato.attivita_1--;
                        (*pl)->dato.cont_negati=0;
                    }else{
                        if((*pl)->dato.cont_negati<3){
                            printf("Codice Fiscale %s, attivita' %d: Accesso negato\n",(*pl)->dato.codice_fiscale,attivita);
                            (*pl)->dato.cont_negati++;
                        }else{
                            printf("Codice Fiscale %s, accessi bloccati\n", (*pl)->dato.codice_fiscale);
                            (*pl)->dato.blocco=0;
                        }
                    }
                }
                break;
            case 2:
                if((*pl)->dato.blocco!=0){
                    if((*pl)->dato.attivita_2>0){
                        (*pl)->dato.attivita_2--;
                        (*pl)->dato.cont_negati=0;
                    }else{
                        if((*pl)->dato.cont_negati<3){
                            printf("Codice Fiscale %s, attivita' %d: Accesso negato\n",(*pl)->dato.codice_fiscale,attivita);
                            (*pl)->dato.cont_negati++;
                        }else{
                            printf("Codice Fiscale %s, accessi bloccati\n", (*pl)->dato.codice_fiscale);
                            (*pl)->dato.blocco=0;
                        }
                    }
                }
                break;
            case 3:
                if((*pl)->dato.blocco!=0){
                    if((*pl)->dato.attivita_3>0){
                        (*pl)->dato.attivita_3--;
                        (*pl)->dato.cont_negati=0;
                    }else{
                        if((*pl)->dato.cont_negati<3){
                            printf("Codice Fiscale %s, attivita' %d: Accesso negato\n",(*pl)->dato.codice_fiscale,attivita);
                            (*pl)->dato.cont_negati++;
                        }else{
                            printf("Codice Fiscale %s, accessi bloccati\n", (*pl)->dato.codice_fiscale);
                            (*pl)->dato.blocco=0;
                        }
                    }
                }
                break;
            default:
                break;
            }
        }
        pl=&(*pl)->next;
    }
}
void stampa_lista(Lista l){
    while(l!=NULL){
        printf("%s: %d %d %d\n",l->dato.codice_fiscale,l->dato.attivita_1,l->dato.attivita_2,l->dato.attivita_3);
        l=l->next;
    }
}