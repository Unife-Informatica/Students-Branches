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

void iniz_Lista(Lista *pl);
void ins_Testa(Lista *pl,Alimento a);
void ins_Coda(Lista *pl,Record r);
float tot_Calorie(Lista l,char cibo[]);