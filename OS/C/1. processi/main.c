#include <stdio.h>
#include <unistd.h>

/*
+------------------------------------+----------------------------------------------------------+
| Chiamata di sistema                | Descrizione                                              |
+------------------------------------+----------------------------------------------------------+
| pid = fork()                       | Crea un processo figlio identico al genitore             |
| pid = waitpid(pid, &statloc, opts) | Aspetta la terminazione del figlio                       |
| s = wait(&status)                  | Vecchia versione di waitpid()                            |
| s = execve(name, argv, envp)       | Sostituisce il programma chiamato al processo corrente   |
| exit(status)                       | Termina il processo in esecuzione e restituisce lo stato |
| pid = getpid()                     | Restituisce il PID del processo                          |
| pid = getppid()                    | Restituisce il PID del processo padre                    |
| pid = getpgrp()                    | Restituisce il Process Group ID del processo             |
+------------------------------------+----------------------------------------------------------+
*/

int main() {
  pid_t pid;

  printf("Prima della fork pid = %d, pid del genitore = %d\n", getpid(), getppid());
  if ((pid = fork()) < 0) {
    // ERRORE -> solitamente se finisce la memoria
    printf("Errore durante la fork.\n");
  } else if (ret == 0) {
    // CODICE FIGLIO
    printf("[Figlio]: valore restituito dalla fork: %d\n", pid);
    printf("[Figlio]: pid = %d, pid del genitore = %d\n", getpid(), getppid());
  } else {
    // CODICE PADRE
    printf("[Genitore]: valore restituito dalla fork: %d\n", pid);
    printf("[Genitore]: pid = %d, pid del mio genitore = %d\n", getpid(), getppid());
    printf("[Genitore]: mio figlio ha pid = %d\n", pid);
  }

  // CODICE CONDIVISO
  return 0;
}
