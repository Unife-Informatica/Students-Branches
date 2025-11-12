typedef struct {
    int chip;
    char type;
} Dog;

typedef struct {
    int cimurro;
    int epatite;
    int parvovirosi;
} Flags;

typedef struct ele {
    Dog d;
    Flags f;
    struct ele *next;
} Node;

typedef Node *List;


// Functions
void addItem(List *l, Dog d);
void printList(List l);
void sortList(List *l);