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
    Alimento alimento;
    struct nodo *next;
}Nodo;
typedef Nodo *Lista;
void iniz_Lista(Lista *pl);
void inserimento_testa(Lista *pl,Alimento a);
void inserimento_coda(Lista *pl,Record r);
float calorieTotali(Lista l,char cibo[]);
