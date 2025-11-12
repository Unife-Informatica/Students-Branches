#include <malloc.h>

int main() {
    int *pa;

    // (int *) castra il risultato in un puntatore ad intero
    // sizeof(int) è lo spazio richiesto da una variabile int
    pa = (int *)malloc(sizeof(int));   // assegna un area di memoria al puntatore pa
    *pa = 7;

    printf("%d\n", *pa / 2);

    free(pa); // dealloca l'area di memoria assegnata precedentemente al puntatore pa

    return 0;
}