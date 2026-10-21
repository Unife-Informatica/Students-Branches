
#include <unistd.h>
#include <string.h>
#include <sys/socket.h> // need for socket()
#include <stdlib.h>     // need for exit()
#include <stdio.h>      // need for perror()
#include <netinet/in.h> // need for sockaddr_in struct
#include <sys/types.h>
#include <signal.h>
#include <errno.h>

#define LEN_MAX 20

typedef struct _MSG
{
    int value;
    char tipo[LEN_MAX];
} MSG;

int main(int argc, char const *argv[])
{
    int sock;
    struct sockaddr_in server, client;
    socklen_t lenght;
    int current_sock;
    int porta = 50000;
    MSG messaggio;

    // 1. SOCKET CREATION
    // socket(domain, type, protocol)
    // AF_INET specify the address family. It use IPv4
    // SOCK_STREAM define the type of socket
    // 0: define the default protocol
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock < 0)
    {
        perror("Socket error");
        exit(EXIT_FAILURE);
    }

    // 2. BINDING
    memset(&server, 0, sizeof(server));
    server.sin_family = AF_INET;                // the same defined inside of socket
    server.sin_addr.s_addr = htonl(INADDR_ANY); // special constant that allows the socket to bind to any available network interface on the machine
    server.sin_port = htons(porta);             // htons() gestisce il numero a livello di byte in modo da non aver interpretazioni errate su diversi sistemi operativi

    if (bind(sock, (struct sockaddr *)&server, sizeof(server)) < 0)
    {
        perror("Binding error");
        close(sock);
        exit(EXIT_FAILURE);
    }

    if (getsockname(sock, (struct sockaddr *)&server, &lenght) < 0)
    { // getsockname() controlla che effettivamente la socket sia associata al server
        perror("Error");
        close(sock);
        exit(EXIT_FAILURE);
    }

    // 3. LISTEN
    if (listen(sock, SOMAXCONN) < 0)
    {
        perror("Listen error");
        close(sock);
        exit(EXIT_FAILURE);
    }

    // Evita che i processi figli terminati rimangano zombie
    signal(SIGCHLD, SIG_IGN);

    printf("Server attivo alla porta: %d\n", ntohs(server.sin_port));
    while (1)
    {
        lenght = sizeof(client);
        current_sock = accept(sock, (struct sockaddr *)&client, &lenght); // la funzione è bloccante per cui l'esecuzione rimarra in attesa

        if (current_sock < 0)
        {
            if (errno == EINTR)
            {
                continue;
            }
            perror("Accept error");
            continue;
        }

        pid_t pid = fork();

        if (pid < 0)
        {
            perror("Fork error");
            close(current_sock);
            continue;
        }

        if (pid == 0)
        {
            // processo figlio -> gestione richiesta
            close(sock);

            size_t ricevuti = 0;

            while (ricevuti < sizeof(messaggio)) {
                ssize_t n = read(current_sock, (char *)&messaggio + ricevuti, sizeof(messaggio) - ricevuti);

                if (n < 0) {
                    if (errno == EINTR) {
                        continue;
                    }

                    perror("Read error");
                    close(current_sock);
                    exit(EXIT_FAILURE);
                }

                if (n == 0) {
                    // Il client ha chiuso la connessione prima di inviare tutto il messaggio
                    close(current_sock);
                    exit(EXIT_FAILURE);
                }

                ricevuti += (size_t)n;
            }

            messaggio.tipo[LEN_MAX - 1] = '\0';

            printf("Ricevuto messaggio da client. Value: %d - Tipo: %s\n", messaggio.value, messaggio.tipo);

            // risposta del server
            messaggio.value = 100;
            strcpy(messaggio.tipo, "Grazie");

            write(current_sock, &messaggio, sizeof(messaggio));
            printf("Risposta inviata. Value: %d - Tipo: %s\n", messaggio.value, messaggio.tipo);

            close(current_sock);
            exit(EXIT_SUCCESS); // esco dal processo figlio in modo che anche il figlio non torni in ascolto
        }
        else if (pid > 0)
        {
            // processo padre
            close(current_sock);
        }
    }

    close(sock);
    return 0;
}