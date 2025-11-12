#include <mm_malloc.h>
int *f(){
    int *pa;
    pa=(int*)malloc(sizeof(int)*5);
    pa[0]=4;
    pa[1]=3;
    pa[2]=2;
    pa[3]=6;
    pa[4]=9;
    return pa;
}
int main(){
    int *pa;
    pa = f();
    printf("%d",pa[3]);
    free(pa);
    pa=NULL;
}