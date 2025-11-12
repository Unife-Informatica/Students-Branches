#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
int main(){
    const char link[]="https://meet.google.com/";
    char code[13];
    char linkC[50];
    int min = 97,max=122;
    int rNum;
    srand(time(NULL));
    for (int i = 0; i < 12; i++)
    {
        rNum = min + rand() % (max - min + 1);
        if(i==3||i==8){
            code[i]=45;
        }else{
            code[i]=rNum;
        }

    }
    code[12]='\0';
    strcpy(linkC,link);
    strcat(linkC,code);
    printf("%s\n",linkC);
    

}