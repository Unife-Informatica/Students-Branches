#define MAX 30

typedef struct {
    char name[MAX];
    char author[MAX];
    int year;
} Data;

typedef struct element {
    Data d;
    struct element * next;
} Node;

typedef Node *Register;

void addBook(Register *r, Data d);
void printRegister(Register r);
Data searchBook(Register r, char *name);
void deleteBook(Register *r, char* name);