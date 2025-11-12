// Tipo di dato della lista
typedef int Data;

typedef struct node {
    Data data;
    struct node *next;
} Node;

typedef Node *Lista;

void randomInit(Lista *pl, int n);

void printList(Lista l);

int massimo(Lista l);
