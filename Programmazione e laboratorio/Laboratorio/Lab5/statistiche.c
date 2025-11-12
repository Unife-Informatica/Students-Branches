#include <stdio.h>
#define DIM 100

int main(){
  int a[DIM], b[DIM],num, max = -1, min, cont, somma = 0;
  float media = 0.0;
  int l=0,p=0;
  int mFreq;

  //input
  for(int i = 0; i < DIM; i++){
    scanf("%d", &num);
    if(num > 0){
      a[i] = num;
      cont++;
    }
  }

  //max
  for(int i = 0; i < cont; i++){
    if(a[i] > max){
      max = a[i];
    }
  }

  //min
  min = max;
  for(int i = 0; i < cont; i++){
    if(a[i] < min){
      min =  a[i];
    }
  }
  
  //media
  for(int i = 0; i < cont; i++){
    somma+=a[i];
  }
  media = somma/cont;

  //numeri frequenti
  for(int i = 0; i < cont; i++){
    l = 0;
    for(int j = 0; j < cont; j++){
      if(a[i] == a[j]){
        l++;
      }
    }
    if(l >= 2){
      mFreq = a[i];
    }
  }

  printf("min = %d\n", min);
  printf("max = %d\n", max);
  printf("media = %.2f\n", media);
  printf("Max frequenza: %d",mFreq);
}