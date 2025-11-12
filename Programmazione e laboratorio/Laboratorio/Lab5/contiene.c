#include <stdio.h>
#include <string.h>

int main() {
    char s1[20], s2[20];
    int l1 = 0, l2 = 0;

    printf("1) Inserisci parola: ");
    scanf("%s", s1);
    printf("2) Inserisci parola: ");
    scanf("%s", s2);

    l1 = strlen(s1);
    l2 = strlen(s2);

    for (int i = 0; i < l1; i++) {
        for (int j = 0; j < l2; j++) {
            if (s1[i] == s2[j]) {
                printf("Il carattere '%c' della prima parola è contenuto nella seconda.\n", s1[i]);
                break; // Evita confronti inutili
            }
        }
    }

    return 0;
}
