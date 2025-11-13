#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <signal.h>

#define DIM 80
#define BUFDIM 256

static volatile sig_atomic_t byte_p2 = 0;

void gestore(int signo){
  printf("Byte letti dal processo P2: %d\n", byte_p2);
  exit(0);
}

int main(int argc, char argv[]){
  int fd, p1, p2, p1p2[2], p2p0[2], status;
  char cognome[DIM];
  char libro[DIM];
  char buff[BUFDIM];
}