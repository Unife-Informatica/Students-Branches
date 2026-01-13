#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

#define DIM_FILEPATH 200
#define DIM_SPETTACOLO 200
#define DIM_RIS 2048
#define ROOT_PATH "/home/studente"

static volatile sig_atomic_t count = 0;

void handler(){
  printf("Numero di richieste servite: %d\n", count);
  exit(0);
}

int main(int argc, char* argv[]){
  int fd, n, status, nread, p1, p2, p3, p1p2[2], p2p3[2], p3p0[2];
  char filepath[DIM_FILEPATH], spettacolo[DIM_SPETTACOLO], ris[DIM_RIS];

  if(argc != 2){
    printf("Errore: numero sbagliato di parametri\n");
    exit(1);
  }

  sprintf(filepath, "%s/%s", ROOT_PATH, argv[1]);
  fd = open(filepath, O_RDONLY);
  if(fd < 0){
    printf("Errore nell'apertura del file");
    exit(2);
  }
  close(fd);

  signal(SIGINT, handler);

  
}