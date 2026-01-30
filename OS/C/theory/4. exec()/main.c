#include <unistd.h>
#include <unistdio.h>
#include <stdio.h>

/*
 * la syscall exec() permette di sostituire il codice che il processo esegue,
 * mantenendo id e parent id.
 * * execl("/bin/program", arg0, arg1, ..., NULL) -> programma con percorso assoluto
 * * execlp("program", arg0, arg1, ..., NULL)     -> nome del programma
 */

int main() {
    printf("Sono il processo con pid: %d\n", getpid());

    execlp("ls", "ls", "-l", "/", NULL);

    // se la execl() va a buon fine la printf() non viene eseguita.
    printf("Sostituzione del codice fallita!\n");

    return 0;
}
