package com.example.model;

public class Evento {
  public String data, descrizione, id;
  public int ora, capienzaMax;
  public double prezzoBiglietto;

  public Evento(){}

  public Evento(String id, String data, int ora, int capienzaMax, double prezzoBiglietto, String descrizione) {
    this.id = id;
    this.data = data;
    this.ora = ora;
    this.capienzaMax = capienzaMax;
    this.prezzoBiglietto = prezzoBiglietto;
    this.descrizione = descrizione;
  }

  public String getData() {
    return data;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public String getId() {
    return id;
  }

  public int getOra() {
    return ora;
  }

  public int getCapienzaMax() {
    return capienzaMax;
  }

  public double getPrezzoBiglietto() {
    return prezzoBiglietto;
  }

  public void setData(String data) {
    this.data = data;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setOra(int ora) {
    this.ora = ora;
  }

  public void setCapienzaMax(int capienzaMax) {
    this.capienzaMax = capienzaMax;
  }

  public void setPrezzoBiglietto(double prezzoBiglietto) {
    this.prezzoBiglietto = prezzoBiglietto;
  }

  @Override
  public String toString(){
    return "Data: " + data +
           ", Descrizione: " + descrizione +
           ", Ora: " + ora +
           ", Capienza Max: " + capienzaMax +
           ", Prezzo Biglietto: " + prezzoBiglietto;
  }
}
