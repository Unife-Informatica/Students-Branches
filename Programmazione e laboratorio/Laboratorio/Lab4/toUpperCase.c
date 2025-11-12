#include<stdio.h>
char toUpperCase(char c){
    if(c>=97&&c<=122){
        c=c-32;
        return c;
    }
    return c;
}
int main(){
    char c;
    printf("Inserisci carattere: ");
    scanf("%c",&c);
    printf("%c\n",toUpperCase(c));
}