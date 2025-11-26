#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
int main(int argc, char **argv){
    printf("A\n");
    fork();
    printf("B\n");
    fork();
    printf("C\n");
}