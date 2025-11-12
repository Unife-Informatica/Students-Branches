typedef struct {
    int matricola;
    int score;
    char type;
} fileStudent;

typedef struct {
    int matricola;
    int pratic_score;
    int theory_score;
} Student;

typedef struct ele {
    Student s;
    struct ele *next;
} Node;

typedef Node *List;


// Functions
void listInit(List *l);
void addItem(List *l, fileStudent s);
void printList(List l);