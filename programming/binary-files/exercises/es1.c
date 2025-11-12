#include <stdio.h>
#include <stdlib.h>

#define DIM 1000

typedef struct {
    char cibo[31];
    float calorie;
} Record;

int main(int argc, char* argv[]) {
    FILE *fp;
    Record r;

    fp = fopen(argv[1], "rb");
    if(fp == NULL) {
        printf("Errore durante l'apertura di %s\n", argv[1]);
        exit(1);
    }

    // viene letto un elemento dal file fp di gradezza sizeof(Record) e lo salva all'interno della variabile r
    // se fread() trova un elemento grande sizeof(Record) ritorna 1 altrimenti 0
    // while(fread(&r, sizeof(Record), 1, fp) == 1)
    //     printf("Cibo: %s - Calorie: %f\n", r.cibo, r.calorie);

    fclose(fp);
    return 0;
}