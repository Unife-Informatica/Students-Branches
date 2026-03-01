#include <stdio.h>
#include <stdlib.h>

#define DIM 4


void insertion_sort(int digits[], int start, int end) {
    int key, i;

    for (int j=1; j<end; ++j) {
        key = digits[j];
        i = j - 1;

        while ((i >= 0) && (digits[i] > key)) {
            digits[i + 1] = digits[i];
            i = i - 1;
        }

        digits[i + 1] = key;
    }
}


void rearrange(int n, int *asc, int *desc) {
    int digits[DIM];

    for (int i=0; i<DIM; ++i) {
        digits[i] = n % 10;
        n = n / 10;
    }

    insertion_sort(digits, 0, DIM);

    *asc = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
    *desc = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];
}


int kaprekar(int n) {
    int steps = 0;
    int asc, desc;

    while (n != 6174) {
        rearrange(n, &asc, &desc);
        n = desc - asc;
        ++steps;
    }

    return steps;
}


void solve(FILE *input_file, FILE *output_file) {
    int N;
    fscanf(input_file, "%d", &N);

    for (int i=0; i<N; ++i) {
        int n;
        fscanf(input_file, "%d", &n);
        fprintf(output_file, "%d\n", kaprekar(n));
    }
}


int main() {
    FILE *input_file, *output_file;

    input_file = fopen("input.txt", "r");
    if (input_file == NULL) {
        perror("Errore durante l'apertura del file per l'input.");
    }
    output_file = fopen("output.txt", "w");
    if (output_file == NULL) {
        perror("Errore durante l'apertura del file per l'output.");
    }

    solve(input_file, output_file);
   
    if (fclose(input_file) != 0) {
        perror("Errore durante la chiusura del file per l'input");
    }
    if (fclose(output_file) != 0) {
        perror("Errore durante la chiusura del file per l'output");
    }

    return EXIT_SUCCESS;
}



