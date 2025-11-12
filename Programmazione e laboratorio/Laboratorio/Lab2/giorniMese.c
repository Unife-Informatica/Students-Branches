#include <stdio.h>

int main(){
    int mese,anno,gMese;
    printf("Inserire mese(Da 1 a 12): ");
    scanf("%d", &mese);
    printf("Inserire anno: ");
    scanf("%d", &anno);
    if(anno%4==0&&anno%100!=0||anno%400==0){
        printf("Il %d e' bisestile\n", anno);
        switch (mese)
            {
                case 1:
                    gMese=31;
                    break;
                case 2:
                    gMese=29;
                    break;
                case 3:
                    gMese=31;
                    break;
                case 4:
                    gMese=30;
                    break;
                case 5:
                    gMese=31;
                    break;
                case 6:
                    gMese=30;
                    break;
                case 7:
                    gMese=31;
                    break;
                case 8:
                    gMese=31;
                    break;
                case 9:
                    gMese=30;
                    break;
                case 10:
                    gMese=31;
                    break;
                case 11:
                    gMese=30;
                    break;
                case 12:
                    gMese=31;
                    break;
            
                default:
                    break;
            }
            printf("Il mese contiene: %d giorni",gMese);
    }else{
            printf("Il %d non e' bisestile\n", anno);
            switch (mese)
            {
                case 1:
                    gMese=31;
                    break;
                case 2:
                    gMese=28;
                    break;
                case 3:
                    gMese=31;
                    break;
                case 4:
                    gMese=30;
                    break;
                case 5:
                    gMese=31;
                    break;
                case 6:
                    gMese=30;
                    break;
                case 7:
                    gMese=31;
                    break;
                case 8:
                    gMese=31;
                    break;
                case 9:
                    gMese=30;
                    break;
                case 10:
                    gMese=31;
                    break;
                case 11:
                    gMese=30;
                    break;
                case 12:
                    gMese=31;
                    break;
            
                default:
                    break;
            }
            printf("Il mese contiene: %d giorni",gMese);
    }

}
       