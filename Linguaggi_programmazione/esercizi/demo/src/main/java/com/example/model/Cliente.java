package com.example.model;

public class Cliente {
  private String nome, cognome, email, numTelefono, id;
  private int eta;

  public Cliente(){}

  public Cliente(String id, String nome, String cognome, int eta, String email, String numTelefono) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.eta = eta;
    this.email = email;
    this.numTelefono = numTelefono;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public String getEmail() {
    return email;
  }

  public String getNumTelefono() {
    return numTelefono;
  }

  public String getId() {
    return id;
  }

  public int getEta() {
    return eta;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setNumTel(String numTelefono) {
    this.numTelefono = numTelefono;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setEta(int eta) {
    this.eta = eta;
  }

  @Override
  public String toString(){
    return "Id: " + id + "Nome: " + nome + "Cognome: " + cognome + "Età: " + eta + "E-mail: " + email + "Num.Telefono: " + numTelefono;
  }
}
