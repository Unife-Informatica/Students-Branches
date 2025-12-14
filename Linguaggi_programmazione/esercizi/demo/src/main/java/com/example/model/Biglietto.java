package com.example.model;

public class Biglietto {
  private Cliente c;
  private Evento e;
  private String dataAquisto;

  public Biglietto(){}

  public Biglietto(Cliente c, Evento e, String dataAquisto) {
    this.c = c;
    this.e = e;
    this.dataAquisto = dataAquisto;
  }

  public Cliente getC() {
    return c;
  }

  public Evento getE() {
    return e;
  }

  public String getDataAquisto() {
    return dataAquisto;
  }

  @Override
  public String toString() {
    return "Acquisto{" +
            "cliente=" + c +
            ", evento=" + e +
            ", dataAcquisto='" + dataAquisto + '\'' +
            '}';
  }
}
