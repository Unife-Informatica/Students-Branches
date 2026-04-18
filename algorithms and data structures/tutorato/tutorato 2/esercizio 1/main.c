#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    long long x = *(long long*)a;
    long long y = *(long long*)b;

    // con queste condizioni, qsort fa un ordinamento ascendente
    if (x < y) return -1;
    if (x > y) return 1;
    return 0;
}

// ricerca binaria con nessuna variazione particolare
int binary_search(long long int *dist, int N, double query){
    int left = 0;
    int right = N;
    int mid;

    while (left < right) {
        mid = left + (right - left) / 2;

        if (dist[mid] <= query) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}

void pianeta_spritz(FILE *in_file, FILE *out_file) {
    int N, Q;
    fscanf(in_file, "%d %d", &N, &Q);

    // distanze di ogni (x,y,z) da (0,0,0)
    long long int dist[N];

    for (int i=0; i<N; ++i) {
        // nuovo asteroide
        long long int x, y, z;
        fscanf(in_file, "%lld %lld %lld", &x, &y, &z);

        // al posto di sqrt(...), salviamo la distanza al quadrato;
        // va bene lo stesso, anzi semplifica l'implementazione perché
        // non dobbiamo lavorare con float, ma dopo dobbiamo considerare
        // query*query anziché query.
        dist[i] = x*x + y*y + z*z;
    }

    // ordiniamo tutta la collezione dist in ordine ascendente con "compare"
    qsort(dist, N, sizeof(dist[0]), compare);

    for (int i=0; i<Q; ++i) {
        // ogni domanda corrisponde a un nuovo raggio
        long long int query;
        fscanf(in_file, "%lld", &query);

        // query al quadrato per via della distanza euclidea al quadrato
        fprintf(out_file, "%d\n", binary_search(dist, N, query * query));
    }
}

int main(void) {
    // si potrebbe essere più puntigliosi e controllare l'apertura
    FILE *in_file = fopen("input.txt", "r");
    FILE *out_file = fopen("output.txt", "w");

    pianeta_spritz(in_file, out_file);

    // anche qua si potrebbe essere più puntigliosi e fare dei controlli
    fclose(in_file);
    fclose(out_file);

    return EXIT_SUCCESS;
}
