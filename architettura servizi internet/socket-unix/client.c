#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <netdb.h>

#define SERVER_PORT 50000
#define LEN_MAX 20

typedef struct _MSG {
    int value;
    char tipo[LEN_MAX];
} MSG;

int main() {
    int client_fd;
    struct sockaddr_in server_address;
    struct hostent *hp;
    MSG messaggio;

    client_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (client_fd < 0) {
        perror("Socket error");
        exit(-1);
    }

    server_address.sin_family = AF_INET;
    server_address.sin_port = htons(SERVER_PORT);
    
    hp = gethostbyname("localhost"); // controllo di essere in localhost visto che la comunicazione avviene sulla stessa macchina
    if(hp < 0) {
        perror("Error localhost");
        exit(-1);
    }

    memcpy((char *)&server_address.sin_addr, (char *)hp->h_addr_list[0], hp->h_length);

    if(connect(client_fd, (struct sockaddr *)&server_address, sizeof(server_address)) < 0) {
        perror("Connect error");
        exit(-1);
    }

    printf("Siamo connessi al server\n");

    messaggio.value = 10;
    strcpy(messaggio.tipo, "Salute");

    if(write(client_fd, &messaggio, sizeof(messaggio)) < 0) {
        perror("Send error");
        exit(-1);
    }
    printf("Messaggio inviato. Value: %d - Tipo: %s\n", messaggio.value, messaggio.tipo);

    if(read(client_fd, &messaggio, sizeof(messaggio)) < 0) {
        perror("Read error");
        exit(-1);
    }
    printf("Risposta. Value: %d - Tipo: %s\n", messaggio.value, messaggio.tipo);

    close(client_fd);

    return 0;
}