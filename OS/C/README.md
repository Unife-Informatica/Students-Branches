# C Notes

## Processi

```c
int status;
pid_t pid = fork();
```

* `fork()` crea un **processo figlio**
* Valori di ritorno:
  * `0` → siamo nel **figlio**
  * `>0` → PID del figlio (siamo nel **padre**)
  * `-1` → errore

### Attesa dei figli

```c
wait(&status);        // attende un figlio qualsiasi
// oppure
waitpid(pid, &status, 0); // attende un figlio specifico
```

* `status` contiene il valore di uscita del figlio
* Per più figli → chiamare `wait()` in un ciclo

```c
for (int i = 0; i < n; i++) {
    wait(NULL);
}
```

> [!NOTE]
> Se creo un array con `malloc()` → **ricorda sempre `free()`**

---

## `execlp()`

Serve per **sostituire il codice del processo corrente** con un altro programma.

```c
execlp("ls", "ls", "-l", NULL);
```

* **Non ritorna** se va a buon fine
* Va usata **dopo `fork()`**
* Il primo argomento è il programma
* Il secondo è `argv[0]`
* Lista di argomenti terminata da `NULL`

### Esempio completo

```c
pid_t pid = fork();

if (pid == 0) {
    execlp("ls", "ls", "-l", NULL);
    perror("execlp");
    exit(1);
}
wait(NULL);
```

---

## Pipe

Le pipe permettono la **comunicazione tra processi** (unidirezionale).

```c
int fd[2];
pipe(fd);
```

* `fd[0]` → lettura
* `fd[1]` → scrittura

---

## Pipe + fork

```c
int fd[2];
pipe(fd);

pid_t pid = fork();

if (pid == 0) {
    close(fd[1]);          // il figlio legge
    read(fd[0], buf, 100);
    close(fd[0]);
} else {
    close(fd[0]);          // il padre scrive
    write(fd[1], msg, strlen(msg));
    close(fd[1]);
}
```

> [!NOTE]
> Chiudi **sempre** i lati inutilizzati della pipe

---

## Pipe + `execlp()`

Simula:

```bash
ls | wc -l
```

```c
int fd[2];
pipe(fd);

if (fork() == 0) {
    // FIGLIO 1: ls
    dup2(fd[1], STDOUT_FILENO);
    close(fd[0]);
    close(fd[1]);
    execlp("ls", "ls", NULL);
    exit(1);
}

if (fork() == 0) {
    // FIGLIO 2: wc -l
    dup2(fd[0], STDIN_FILENO);
    close(fd[1]);
    close(fd[0]);
    execlp("wc", "wc", "-l", NULL);
    exit(1);
}

close(fd[0]);
close(fd[1]);
wait(NULL);
wait(NULL);
```

`execlp()` sostituisce il processo
pipe = collegamento tra stdout → stdin

---

## File

### Apertura

```c
int fd = open("file.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);
```

* I **bit di protezione** servono solo con `O_CREAT`
* Ricorda sempre:

```c
close(fd);
```

---

### Scrittura

```c
char log[256];
sprintf(log, "%d\n", n);
write(fd, log, strlen(log));
```

> [!NOTE] 
> `write()` **non** aggiunge `\0`

---

## Segnali

### Handler

```c
void handler(int signo) {
    // gestione segnale
    exit(0);
}
```

### Installazione corretta

```c
struct sigaction sa;
sa.sa_handler = handler;
sigemptyset(&sa.sa_mask);
sa.sa_flags = 0;

sigaction(SIGINT, &sa, NULL);
```

* `SIGINT` → Ctrl+C
* `sigaction()` **va sempre chiamata**, altrimenti non serve a nulla

---

## Funzioni principali

* `fork()` → crea processo
* `wait()` → sincronizzazione
* `pipe()` → comunicazione
* `execlp()` → nuovo programma
* `open/write/close` → file
* `sigaction()` → segnali
