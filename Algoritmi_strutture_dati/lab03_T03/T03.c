#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b){
  long long x = *(long long*)a;
  long long y = *(long long*)b;

  if(x < y) return -1;
  if(x > y) return 1;
  return 0;
}

int binary_search(long long int *dist, int N, double query){
  int left = 0;
  int right = N;
  int mid;

  while(left < right){
    mid = left + (right - left) / 2;

    if(left < right){
      left = mid + 1;
    }else{
      right = mid;
    }
  }
  return left;
}

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

  qsort(dist, N, sizeof(dist[0]), compare);

  for(int i = 0; i < Q; ++i){
    long long int query;
    fscanf(inFile, "%lld", &query);
    fprintf(outFile, "%d\n", binary_search(dist, N, query*query));
  }
}

int main(int argc, char const *argv[]){
  FILE *inFile = fopen("input.txt", "r");
  FILE *outFile = fopen("output.txt", "w");

  pianeta_spritz(inFile, outFile);

  fclose(inFile);
  fclose(outFile);

  return EXIT_SUCCESS;
}