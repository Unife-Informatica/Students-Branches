#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DIM 4

void insertion_sort(int digits[], int start, int end) {
    int key;
}

void rearrange(int n, int *asc, int *desc) {
    int digits[DIM];

    for (int i = 0; i < DIM; ++i) {
        digits[i] =  n%10;
        n = n / 10;
    }

    insertion_sort(digits, 0, DIM - 1);

    *asc = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];
    *desc = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
}

int kaprekar(int n) {
    int steps = 0;
    int asc, desc;

    while(n != 6174) {
        rearrange(n, &asc, &desc);
        n = desc - asc;
        ++steps;
    }

    return steps;
}

void solve(FILE *input_file, FILE *output_file) {
    int n;
    fscanf(input_file, "%d", &n);

    for(int i = 0; i < n; ++i) {
        int target;
        fscanf(input_file, "%d", &n);
        fprintf(output_file, "%d", kaprekar(n));
    }
}

int main() {
  FILE *input_file, *output_file;

  input_file = fopen("input.txt", "r");
  if(input_file == NULL) {
      fprintf(stderr, "[Errore]: %s", strerror(errno));
  }

  output_file = fopen("output.txt", "w");
  if(output_file == NULL) {
      fprintf(stderr, "[Errore]: %s", strerror(errno));
  }

  solve(input_file, output_file);

  if(fclose(input_file) == EOF) {
      fprintf(stderr, "[Errore]: %s", strerror(errno));
  }

  if(fclose(output_file) == EOF) {
      fprintf(stderr, "[Errore]: %s", strerror(errno));
  }

  return EXIT_SUCCESS;
}
