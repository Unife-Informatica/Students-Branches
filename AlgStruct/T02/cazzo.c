#include <stdio.h>
int main(int argc, char const *argv[])
{
    /*int m = 53;
    printf("%d",m%10);
    return 0;*/
    /*
    int n = 5399;
    int digits[4];

    for(int i=3;i>=0;i--){
        digits[i]=n%10;
        n = n/10;
    
    }
    for(int i = 0; i<4;i++){
        printf("%d",digits[i]);
    }
    */
   int n=12;
   int e=12;
   long long result=1;
   for(int i=0;i<e;i++){
    result = (result*e);

   }
   //printf("%lld",result);
   long num =100385844;
   long m =1000000007; 
   long res = num*m;
   printf("%ld",res);
}
