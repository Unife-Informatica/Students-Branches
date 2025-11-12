#include <stdio.h>
#include <string.h>

#define MAX_LIST 100
#define MAX_STR 20

typedef struct {
    char constructor[MAX_STR];
    int t_access;
    int price;
} Type;

typedef struct {
    Type arr[MAX_LIST];
    int i;
} Lista;

void ricerca(Lista *l, int max_t_access, int max_price) {
    for(int i = 0; i < l->i; i++) {
        if(l->arr[i].price < max_price && l->arr[i].t_access < max_t_access) {
            printf("%s\t%d\t%d\n", l->arr[i].constructor, l->arr[i].t_access, l->arr[i].price);
        }
    }
}

void getData(Lista *l, char *fileName) {
    FILE *fp;
    Type tmp;
    int i = 0;

    fp = fopen(fileName, "r");

    while(fscanf(fp, "%s %d %d", tmp.constructor, &tmp.t_access, &tmp.price) == 3) {
        l->arr[i] = tmp;
        l->i = i;
        i++;
    }

    fclose(fp);
}

int main() {
    Lista l;
    int max_t_access, max_price;

    printf("Inserire la soglia massima del tempo di accesso: ");
    scanf("%d", &max_t_access);

    printf("Inserire il prezzo massimo: ");
    scanf("%d", &max_price);


    getData(&l, "memory.txt");

    ricerca(&l, max_t_access, max_price);
}