#include <stdio.h>
#include <malloc.h>

int *f() {
    int *pa;
    
    // se avessi dichiarato pa come variabile locale(es int a = ...; return a;) questa sarebbe stata eliminata una volta eseguita la funzione
    // in questo caso vado a riservare un area di memoria che non verrà cancellata fino alla chiamata della funzione free()
    pa = (int *)malloc(sizeof(int)*5);
    pa[0] = 5;
    pa[1] = 4;
    pa[2] = 3;
    pa[3] = 2;
    pa[4] = 1;

    return pa;
}

int main() {
    int *pa;

    pa = f();

    printf("%d\n", pa[3]);
}