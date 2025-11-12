typedef struct {
    char primo[10];
    char secondo[10];
    char terzo[10];
} Record;

typedef struct {
    char nome[10];
    int oro;
    int argento;
    int bronzo;
} Paese;

typedef struct ele {
    Paese p;
    struct ele *next;
} Nodo;

typedef Nodo *Lista;


// Functions
void nuovaLista(Lista *l);
void addItem(Lista *l, char nome[10], int posizione);
void sortList(Lista *l);
void stampaLista(Lista l);