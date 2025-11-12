typedef struct
{
    char targa[8];
    float durata;
} Sosta;

typedef struct ele {
    Sosta s;
    int ingressi;
    float price;
    struct ele *next;
} Nodo;

typedef Nodo* Lista;

void insTesta(Lista *l, Sosta s);

void calcolaImporto(Lista l);

void storicoTarghe(char filename[], Lista l);