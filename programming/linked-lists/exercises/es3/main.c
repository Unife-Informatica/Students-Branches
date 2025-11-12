#include "register.h"
#include "string.h"
#include <stdio.h>

int main() {
    Register r = NULL;
    Data d1 = { "Libro 1", "Pietro", 1945 };
    Data d2 = { "Libro 2", "Pietro", 1945 };
    Data d3 = { "Libro 3", "Pietro", 1945 };

    addBook(&r, d1);
    addBook(&r, d2);

    Data result = searchBook(r, "Libro 2");

    printf("%s, %s, %d\n", result.name, result.author, result.year);

    addBook(&r, d3);

    printRegister(r);
}