#include <stdio.h>
#include <string.h>

#define MAX 10

typedef struct
{
    char nome[20];
    char cognome[20];
    int matricola;
} Studente;

typedef struct
{
    Studente list[MAX];
    int i;
} Lista;

void getData(char *fileName, Lista *l)
{
    Studente s;
    int i = 0;
    FILE *fp;
    fp = fopen("file.txt", "r");

    while (fscanf(fp, "%s %s %d", s.nome, s.cognome, &s.matricola) == 3)
    {
        strcpy(l->list[i].nome, s.nome);
        strcpy(l->list[i].cognome, s.cognome);
        l->list[i].matricola = s.matricola;

        l->i = i;
        i++;
    }

    fclose(fp);
}

void stampaStudenti(Lista s)
{
    for (int i = 0; i < s.i; i++)
    {
        printf("%s\t%s\t%d\n", s.list[i].nome, s.list[i].cognome, s.list[i].matricola);
    }
}

void swap(Studente *n1, Studente *n2) {
    Studente c;
    c = *n1;
    *n1 = *n2;
    *n2 = c;
}

void ordinaStudenti(Lista *s){
    int max;
    int maxID;

    for(int i = 0; i < s->i; i++) {
        max = s->list[i].matricola;
        for(int j = i; j < s->i; j++) {
            if(s->list[j].matricola >= max) {
                max = s->list[j].matricola;
                maxID = j;
            }
        }
        swap(&(s->list[i]), &(s->list[maxID]));
        max = 0;
    }
}

void saveStudents(char *filename, Lista l) {
    FILE *fp;

    fp = fopen(filename, "wt");

    for(int i = 0; i < l.i; i++)
        fprintf(fp, "%s %s %d\n", l.list[i].nome, l.list[i].cognome, l.list[i].matricola);

    fclose(fp);
}

int main(int argc, char const *argv[])
{
    Lista l;

    getData("file.txt", &l);
    ordinaStudenti(&l);
    stampaStudenti(l);

    saveStudents("ordinati.txt", l);

    return 0;
}
