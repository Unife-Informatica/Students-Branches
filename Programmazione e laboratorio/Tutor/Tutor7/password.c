#include <stdio.h>
#include <string.h>
#define DIM 20
char sostituisciPass(char pass[],char nPass[]){
    while (strlen(pass)<8&&strcmp(pass,nPass)!=1&&!strpbrk(pass,"?!*"))
    {
        scriviPassword(pass,nPass);
    }
    
}
void scriviPassword(char pass[],char nPass[]){
    strcpy(newP,pass);
    printf("Inserisci una nuova password:");
    scanf("%s",pass);
    
}
int main(){
    char password[DIM]="Giggino?";
    char newP[DIM];
    scriviPassword(password,newP);
    sostituisciPass(password,newP);
    printf("%s",password);
}