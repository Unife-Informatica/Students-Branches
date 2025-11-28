package it.unife.lp.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
	private final StringPropertyWrapper Nome;
	private final StringPropertyWrapper Descrizione;
	private final StringPropertyWrapper orario;
	private final StringPropertyWrapper istruttore;
    private final ObservableList<Person> iscritti = FXCollections.observableArrayList();

	
	public Activity() {
		this("Corso", "Michael Jackson");
	}


	@JsonCreator
	public Activity(@JsonProperty("Nome") String nome, @JsonProperty("istruttore") String istruttore) {
		this.Nome = new StringPropertyWrapper(nome);
		this.istruttore = new StringPropertyWrapper(istruttore);
		this.orario = new StringPropertyWrapper("");
		this.Descrizione = new StringPropertyWrapper("");
	}

	public String getNome() {
		return Nome.getValue();
	}
	
	public void setNome(String Nome) {
		this.Nome.setValue(Nome);
	}

	@SuppressWarnings("exports")
	public StringProperty nameProperty() {
		return Nome.toStringProperty();
	}

	public String getDescrizione() {
		return Descrizione.getValue();
	}
	
	public void setDescrizione(String Descrizione) {
		this.Descrizione.setValue(Descrizione);;
	}
	
	@SuppressWarnings("exports")
	public StringProperty DescProperty() {
		return Descrizione.toStringProperty();
	}

	
	public String getOrario() {
		return orario.getValue();
	}
	
	public void setOrario(String orario) {
		this.orario.setValue(orario);
	}
	
	@SuppressWarnings("exports")
	public StringProperty OrarioProperty(){
		return orario.toStringProperty();
	}

	public String getIstruttore() {
		return istruttore.getValue();
	}
	
	public void setIstruttore(String istruttore) {
		this.istruttore.setValue(istruttore);
	}
	
	@SuppressWarnings("exports")
	public StringProperty teacherProperty() {
		return istruttore.toStringProperty();
	}

	@JsonIgnore
    public ObservableList<Person> getIscritti() {
        return iscritti;
    }

	@JsonProperty("iscritti")
    public List<Person> getIscrittiForSerialization() {
        return new ArrayList<>(iscritti);
    }

    @JsonProperty("iscritti")
    public void setIscrittiForDeserialization(List<Person> iscritti) {
        this.iscritti.setAll(iscritti);
    }

    public void addIscritto(Person iscritto) {
        iscritti.add(iscritto);
    }

    public void removeIscritto(Person iscritto) {
        iscritti.remove(iscritto);
    }
}
