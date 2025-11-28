package it.unife.lp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private final StringProperty nome;
    private final StringProperty cognome;
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty address;
    private final StringProperty phone;
    private final StringProperty email;
    private final StringProperty iscritto;
    private final ObservableList<Presence> presenze;

    public Person() {
        this(null, null);
    }
    
    @JsonCreator
    public Person(@JsonProperty("nome") String nome, @JsonProperty("cognome") String cognome) {
        this.nome = new SimpleStringProperty(nome);
        this.cognome = new SimpleStringProperty(cognome);
        this.address = new SimpleStringProperty("Ferrara");
        this.phone = new SimpleStringProperty("321 4567890");
        this.email = new SimpleStringProperty("esempio@gmail.com");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(2000, 1, 1));
        this.iscritto = new SimpleStringProperty("No");
        this.presenze = FXCollections.observableArrayList();
    }
    
    @JsonProperty("nome")
    public String getNome() {
        return nome.get();
    }

    @JsonProperty("nome")
    public void setFirstName(String firstName) {
        this.nome.set(firstName);
    }
    
    @SuppressWarnings("exports")
    public StringProperty firstNameProperty() {
        return nome;
    }

    @JsonProperty("cognome")
    public String getCognome() {
        return cognome.get();
    }

    @JsonProperty("cognome")
    public void setLastName(String lastName) {
        this.cognome.set(lastName);
    }
    
    @SuppressWarnings("exports")
    public StringProperty lastNameProperty() {
        return cognome;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address.get();
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address.set(address);
    }
    
    @SuppressWarnings("exports")
    public StringProperty addressProperty() {
        return address;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone.get();
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    
    @SuppressWarnings("exports")
    public StringProperty phoneProperty() {
        return phone;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email.get();
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email.set(email);
    }
    
    @SuppressWarnings("exports")
    public StringProperty emailProperty() {
        return email;
    }

    @JsonProperty("birthday")
    public LocalDate getBirthday() {
        return birthday.get();
    }

    @JsonProperty("birthday")
    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
    
    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    @JsonProperty("iscritto")
    public String getIscritto() {
        return iscritto.get();
    }

    @JsonProperty("iscritto")
    public void setIscritto(String iscritto) {
        this.iscritto.set(iscritto);
    }
    
    @SuppressWarnings("exports")
    public StringProperty iscrittoProperty() {
        return iscritto;
    }

    @JsonProperty("presenze")
    public ObservableList<Presence> getPresenze() {
        return presenze;
    }

    @JsonProperty("presenze")
    public void setPresenze(List<Presence> presenze) {
        this.presenze.setAll(presenze);
    }

    public void addPresenza(Presence presenza) {
        this.presenze.add(presenza);
    }

    public void removePresenza(Presence presenza) {
        this.presenze.remove(presenza);
    }
}