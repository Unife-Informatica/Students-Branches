#include <string.h>
#include <stdio.h>
#include "biblioteca.h"
void inizializza_biblioteca(Biblioteca *l){
    for (int i = 0; i < DIM; i++)
    {
        strcpy(l->libri[i].autore,"Tutto");
        strcpy(l->libri[i].titolo,"Succhiamelo");
        l->libri[i].anno_pubblicazione=0;
    }
    l->indice_corrente=0;
}
void inserimento_biblioteca(Biblioteca *l,Libro b){
    strcpy(l->libri[l->indice_corrente].titolo,b.titolo);
    strcpy(l->libri[l->indice_corrente].autore,b.autore);
    l->libri[l->indice_corrente].anno_pubblicazione=b.anno_pubblicazione;
    l->indice_corrente++;
}
void ricerca_libro(Biblioteca l,char titolo[]){
    for (int i = 0; i < l.indice_corrente; i++)
    {
        if(strcmp(l.libri[i].titolo,titolo)==0){
            printf("Titolo: %s|Autore: %s|Anno: %d\n",l.libri[i].titolo,l.libri[i].autore,l.libri[i].anno_pubblicazione);
        }
        printf("\n");
    }
    
}
void stampa_biblioteca(Biblioteca l){
    for (int i = 0; i <l.indice_corrente; i++)
    {
        printf("Titolo: %s|Autore: %s|Anno: %d\n",l.libri[i].titolo,l.libri[i].autore,l.libri[i].anno_pubblicazione);
    }
}