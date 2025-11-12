#include <stdio.h>
#define DIM 100
typedef struct{
  int num;
  int freq;
}Frequenze;
void leggiNum(int a[], int *cont){
  int num;
  for(int i = 0; i < DIM; i++){
    scanf("%d", &num);
    if(num > 0){
      a[i] = num;
      (*cont)++;
    }else{
      break;
    }
  }
}

void minimo(int a[], int *min, int *cont){
  for(int i = 0; i < *cont; i++){
    if(a[i] < *min){
      *min = a[i];
    }
  }
}

void massimo(int a[], int *max, int *cont){
  for(int i = 0; i < *cont; i++){
    if(a[i] > *max){
      *max = a[i];
    }
  }
}

int calcolaSomma(int a[], int *cont){
  int somma = 0;
  for(int i = 0; i < *cont; i++){
    somma+=a[i];
  }
  return somma;
}

void calcolaMedia(int a[], float *media, int *cont){
  int somma = calcolaSomma(a, cont);
  *media = somma/(*cont);
}

void ordina(int a[], int b[], int *cont, int *contL){
  *contL = 0;
  for (int i = 0; i < *cont; i++) {
    int duplicato = 0;
    for (int j = 0; j < *contL; j++) {
      if(a[i] == b[j]) {
        duplicato = 1;
        break;
      }
    }
    if(!duplicato){
      b[*contL] = a[i];
      (*contL)++;
    }
  }
}

void calcolaFrequenze(int a[],int b[],Frequenze c[],int *cont,int *contL){
    int freq;
    for (int i = 0; i < *contL; i++)
    {
        freq=0;
        for (int j = 0; j < *cont; j++)
        {
            if(b[i]==a[j]){
                freq++;
            }
        }
        c[i].num=b[i];
        c[i].freq=freq;
        
    }
    
}

int main(){
  int numeri[DIM], ordinati[DIM];
  int cont = 0, contF = 0, contL = 0;
  int max = -1, min;
  float media;
  Frequenze contFrq[DIM];
  leggiNum(numeri, &cont);
  massimo(numeri, &max, &cont);
  min = max;
  minimo(numeri, &min, &cont);
  calcolaMedia(numeri, &media, &cont);
  ordina(numeri, ordinati, &cont, &contL);
  calcolaFrequenze(numeri,ordinati,contFrq,&cont,&contL);
  printf("Massimo: %d\nMinimo: %d\nMedia: %f\n",max,min,media);
  for(int i = 0; i < contL; i++){
    printf("%d-%d\n", ordinati[i],contFrq[i].num);
  }
  
  //printf("%f\n", media);
}