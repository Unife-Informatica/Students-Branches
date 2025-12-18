package com.example.model;

public class Utente {
    private String id,nome,cognome,email;
    public Utente(){}
    public Utente(String id, String nome, String cognome, String email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utente{");
        sb.append("id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }
}
