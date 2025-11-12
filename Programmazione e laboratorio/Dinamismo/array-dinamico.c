#include <mm_malloc.h>
#define DIM 10
int *alloca(int quanti_interi){
        int *pf;
        pf=(int*)malloca(sizeof(int)*quanti_interi);
}
int main(){
    int *pa;
    int dl;
    printf("Quanti interi vuoi inserire: ");
    scanf("%d",&dl);
    pa=alloca(dl);
    for (int i = 0; i < dl; i++)
    {
        scanf("%d",&pa[i]);
    }
    
}