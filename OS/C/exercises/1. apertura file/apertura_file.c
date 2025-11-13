#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {

  int file_descriptor;
  int i = 0; // indice per scorrere gli argomenti

  // per controllare se file esiste, provo ad aprirlo

  /*
  la open() potrebbe fallire anche se il file esiste, ad
  esempio nel caso in cui manchino i permessi di lettura, allora
  per gestire anche tale casistica, possiamo controllare il valore
  di errno
  */

  // provo ad aprire il file in solo lettura. Se open() fallisce ritorna -1
  if ((file_descriptor = open(argv[i], O_RDONLY)) < 0) {
    // errno viene impostato automaticamente da open() in caso di errore
    // ENOENT = "No such file or directory"
    if (errno == ENOENT) {
      fprintf(stderr, "[Errore]: %s non esiste", argv[i]);
      exit(2);
    } else if (errno == EACCES) {
      fprintf(stderr, "[Errore]: non hai i permessi per leggere %s", argv[i]);
      exit(3);
    } else {
      perror("[Errore]: errore durante l'apertura del file");
      exit(4);
    }
  }

  printf("File %s aperto correttamente", argv[1]);
  close(file_descriptor);
  return 0;
}
