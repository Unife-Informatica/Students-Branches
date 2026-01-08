package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Libro {

    @JsonProperty("ISBN")
    private String ISBN;

    private String titolo;
    private String autore;
    private String genere;
    private int anno;

    // Costruttore vuoto (necessario per Jackson)
    public Libro() {
    }

    public Libro(String ISBN, String titolo, String autore, String genere, int anno) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.anno = anno;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", anno=" + anno +
                '}';
    }
}
