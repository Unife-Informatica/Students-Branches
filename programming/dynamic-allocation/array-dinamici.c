#include <stdio.h>
#include <malloc.h>

int *alloca(unsigned int n) {
    int *pa;

    pa = (int *)malloc(sizeof(int) * n);

    return pa;
}

int main() {
    int n;
    int *pa;

    printf("N interi: ");
    scanf("%d", &n);

    pa = alloca(n);

    for(int i = 0; i < n; i++) {
        scanf("%d", &pa[i]);
    }

    free(pa);

    return 0;
}