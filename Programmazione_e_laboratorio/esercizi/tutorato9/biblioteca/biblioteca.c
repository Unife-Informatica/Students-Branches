#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include "biblioteca.h"

void inizializzaBiblio(Biblioteca *b){
  for(int i = 0; i < DIM; i++){
    strcpy(b->libri[i].autore, "Vuoto");
    strcpy(b->libri[i].titolo, "Vuoto");
    b->libri[i].annoPub = 0;
  }
  b->indiceCorrente = 0;
}

void stampaBiblioteca(Biblioteca b){
  for(int i = 0; i < b.indiceCorrente; i++){
    printf("Titolo: %s\n", b.libri[i].titolo);
    printf("Autore: %s\n", b.libri[i].autore);
    printf("Anno pubblicazione: %d\n", b.libri[i].annoPub);
    printf("\n");
  }
}

void popolaBiblioteca(Biblioteca *b, Libro l){
  strcpy(b->libri[b->indiceCorrente].titolo, l.titolo);
  strcpy(b->libri[b->indiceCorrente].autore, l.autore);
  b->libri[b->indiceCorrente].annoPub = l.annoPub;
  b->indiceCorrente++;
}

void cercaLibro(Biblioteca b, char titolo[]){
  for(int i = 0; i < b.indiceCorrente; i++){
    if(strcmp(titolo, b.libri[i].titolo) == 0){
      printf("Titolo: %s\n", b.libri[i].titolo);
      printf("Autore: %s\n", b.libri[i].autore);
      printf("Anno pubblicazione: %d\n", b.libri[i].annoPub);
      printf("\n");
    }
  }
}