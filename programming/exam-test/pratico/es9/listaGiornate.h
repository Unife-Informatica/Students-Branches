typedef struct {
    int day;
    int month;
    float hours;
    char activities[30];

} Record;

typedef struct {
    int day;
    int month;
    float total;
} Worker;

typedef struct ele{
    Worker w;
    struct ele *next;
} Node;

typedef Node *List;


// FUNCTIONS
void initList(List *l);
void update(List *l, Record r);
void printList(List l);