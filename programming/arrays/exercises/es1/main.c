#include <stdio.h>
#include <string.h>
#include <malloc.h>

#define ROWS 5
#define COLS 4

typedef char *Arr[ROWS][COLS];

// per inizializzarla senza puntatore
// typedef char Arr[COLS][ROWS][MAX_LENGHT];

void initializer(Arr arr)
{
    for (int i = 0; i < ROWS; i++)
        for (int j = 0; j < COLS; j++)
        {
            // 20 = numero di caratteri, 1 = terminatore di stringa
            arr[i][j] = (char *)malloc((20 + 1) * sizeof(char));
            strcpy(arr[i][j], "vuoto");
        }
}

void printAll(Arr arr)
{
    printf("\tSLOT 1\tSLOT 2\tSLOT 3\tSLOT 4\t\n");
    for (int i = 0; i < ROWS; i++)
    {
        switch (i)
        {
        case 0:
            printf("Lunedi\t");
            break;
        case 1:
            printf("Martedi\t");
            break;
        case 2:
            printf("Mercoledi\t");
            break;
        case 3:
            printf("Giovedi\t");
            break;
        case 4:
            printf("Venerdi\t");
            break;
        }

        for (int j = 0; j < COLS; j++)
        {
            printf("%s\t", arr[i][j]);
        }
        printf("\n");
    }
}

void dailyPrint(Arr arr)
{
    int day;

    printf("1. Lunedi\n2. Martedi\n3. Mercoledi\n4. Giovedi\n5. Venerdi\n");
    scanf("%d", &day);

    for (int i = 0; i < COLS; i++)
    {
        printf("%s\t", arr[day - 1][i]);
    }

    printf("\n");
}

void edit(Arr arr)
{
    int slot, day;
    char materia[20];

    printf("1. Lunedi\n2. Martedi\n3. Mercoledi\n4. Giovedi\n5. Venerdi\n");
    scanf("%d", &day);

    printf("1. SLOT 1\n2. SLOT 2\n3. SLOT 3\n4. SLOT 4\n");
    scanf("%d", &slot);

    printf("Inserire la materia: ");
    scanf("%s", materia);

    strcpy(arr[day - 1][slot - 1], materia);
}

int main(int argc, char const *argv[])
{
    Arr arr;
    char cmd;

    // passo arr perché arr è puntatore di se stesso
    initializer(arr);

    while (1)
    {
        // visual menu
        printf("a -> stampa completo\nb -> stampa giornaliero\nc -> modifica\nq -> quit\n");

        // input comando
        scanf("%c", &cmd);

        if (cmd == 'q')
        {
            break;
        }

        switch (cmd)
        {
        case 'a':
            printAll(arr);
            break;
        case 'b':
            dailyPrint(arr);
            break;
        case 'c':
            edit(arr);
            break;
        }
    }

    return 0;
}
