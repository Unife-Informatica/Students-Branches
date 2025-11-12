#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct{
    char cibo[31];
    float calorie;
}Record;
typedef struct{
    char cibo[31];
    float calorie;
}Alimento;
typedef struct nodo{
    Alimento dato;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void iniz_lista(Lista *pl);
void ins_testa(Lista *pl,Alimento a);
void ins_ordinato(Lista *pl,Record r);
float calorie(Lista l,char cibo[31]);
