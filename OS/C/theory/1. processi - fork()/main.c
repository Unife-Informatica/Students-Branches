#include <stdio.h>
#include <threads.h>
#include <unistd.h>
#include <sys/wait.h>

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

/*
 * Funzione fork()
 * * processo padre  -> ritorna il pid del processo figlio (valore > 0)
 * * processo figlio -> ritorna 0
 * * errore          -> ritorna -1
 */

int main() {
  pid_t pid;
  int a = 5;

  printf("Prima della fork pid = %d, pid del genitore = %d\n", getpid(), getppid());
  if ((pid = fork()) < 0) {
    // ERRORE -> solitamente se finisce la memoria
    printf("Errore durante la fork.\n");
  } else if (pid == 0) {
    // CODICE FIGLIO
    printf("[Figlio]: valore restituito dalla fork: %d\n", pid);
    printf("[Figlio]: pid = %d, pid del genitore = %d\n", getpid(), getppid());

    a = 10;
    printf("a = %d", a); // Output = 10
  } else {
    // CODICE PADRE
    printf("[Genitore]: valore restituito dalla fork: %d\n", pid);
    printf("[Genitore]: pid = %d, pid del mio genitore = %d\n", getpid(), getppid());
    printf("[Genitore]: mio figlio ha pid = %d\n", pid);

    printf("a = %d", a); // Output = 5
  }

  // aspetta che il figlio finisca l'esecuzione
  // se il padre finisce prima del figlio quest'ultimo avrà un parent id errato
  wait(NULL);

  // CODICE CONDIVISO
  return 0;
}
