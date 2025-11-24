# Appunti

## Processi
```c
int status;
int pid = fork(); // posso creare anche un array nel caso volessi creare piu processi
wait(&status); // attende il valore di ritorno dei figli. posso ciclare la funzione nel caso di piu filgi
```
*Se viene creato un'array con malloc usa free() alla fine*

## `execlp`

## File

### Apertura
```c
int fd = open(file_name, metodi, bit_protezione) // i bit devono essere specificati solo nel caso di creazione del file
```
*Ricorda di chiudere il file*

### Scrittura
```c
char log[256];
sprintf(log, "%d", n);
write(fd, log, strlen(log));
```

## Segnali
```C
void manager(int signo) {
  // code
  exit(0); // eseguito con successo
}
int main() {
  struct sigaction sa;
  sigemptyset(&sa.sa_mask);
  sa.sa_flags = 0;
  sa.sa_handler = manager; // definisce la funzione chiamata all'arrivo del segnale
}
```
