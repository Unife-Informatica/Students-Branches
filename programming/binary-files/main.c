#include <stdio.h>

int main() {
    int a[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    FILE *pfb;

    pfb = fopen("Interi.dat", "wb");   // apre un file di tipo binario

    // case 1
    for(int i = 0; i < 10; i++) {
        fwrite(&a[i], sizeof(int), 1, pfb);  // fwrite(indirizzo_valore, grandezza_tipo_valore, numero_caratteri_da_copiare, file)
    }

    // case 2
    // fwrite(&a[0], sizeof(int), 10, pfb);
    fclose(pfb);

    return 0;
}