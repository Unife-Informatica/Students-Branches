#include <stdio.h>
#include <stdlib.h>

//to Do

void pianeta_spritz(FILE *inFile, FILE *outFile){
  int N, Q;
  fscanf(inFile, "%d %d", &N, &Q);

  // distanze di ogni (x,y,z) da (0,0,0)
  long long int dist[N];

  for(int i = 0; i < N; ++i){
    long long int x, y, z;
    fscanf(inFile, "%lld %lld %lld", &x, &y, &z);

    dist[i] = x*x, y*y, z*z;
  }
}

int main(int argc, char const *argv[]){
  FILE *inFile = fopen("input.txt", "r");
  FILE *outFile = fopen("output.txt" "w");

  pianeta_spritz(inFile, outFile);

  fclose(inFile);
  fclose(outFile);

  return EXIT_SUCCESS;
}