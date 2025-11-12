typedef struct {
    int day;
    int month;
    int year;
    char cf[17];
    char type;
} FileData;

typedef struct {
    char cf[17];
    int tampone;
    int vaccino;
} Person;

typedef struct ele {
    Person p;
    struct ele *next;
} Node;

typedef Node *List;


// Functions
void initList(List *l);
void addItem(List *l, FileData fd);
void sortList(List *l);
void printList(List l);