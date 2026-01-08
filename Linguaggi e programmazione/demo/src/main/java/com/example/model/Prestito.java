package com.example.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prestito {

    @JsonProperty("ISBN")
    private String ISBN;

    @JsonProperty("utente")
    private Utente utente;

    @JsonProperty("dataInizio")
    private Date dataInizio;

    @JsonProperty("dataFinePrevista")
    private Date dataFinePrevista;

    @JsonProperty("attivo")
    private boolean attivo;

    // Costruttore vuoto
    public Prestito() {
        this.attivo = true;
    }

    public Prestito(String ISBN, Utente utente, Date dataInizio, Date dataFinePrevista) {
        this.ISBN = ISBN;
        this.utente = utente;
        this.dataInizio = dataInizio;
        this.dataFinePrevista = dataFinePrevista;
        this.attivo = true;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFinePrevista() {
        return dataFinePrevista;
    }

    public void setDataFinePrevista(Date dataFinePrevista) {
        this.dataFinePrevista = dataFinePrevista;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
}
