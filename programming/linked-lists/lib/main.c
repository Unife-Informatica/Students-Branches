#include <stdio.h>
#include <stdlib.h>

#include "linked-list.h"

int main() {
    Lista l;

    randomInit(&l, 5);

    printList(l);

    deleteItem(&l, 1);

    printList(l);
}