package it.unife.lp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Presence {

    private ObjectProperty<LocalDate> date;
    private IntegerProperty entranceHour;
    private IntegerProperty exitHour;

    public Presence() {
        this.date = new SimpleObjectProperty<>();
        this.entranceHour = new SimpleIntegerProperty();
        this.exitHour = new SimpleIntegerProperty();
    }
    
    public Presence(@JsonProperty("date") LocalDate date, @JsonProperty("entranceHour") int entranceHour, @JsonProperty("exitHour") int exitHour) {
        this.date = new SimpleObjectProperty<>(date);
        this.entranceHour = new SimpleIntegerProperty(entranceHour);
        this.exitHour = new SimpleIntegerProperty(exitHour);
    }
    
    @JsonProperty("entranceHour")
    public int getEntranceHour() {
        return entranceHour.get();
    }

    @JsonProperty("entranceHour")
    public void setEntranceHour(int entranceHour) {
        this.entranceHour.set(entranceHour);
    }

    @SuppressWarnings("exports")
    public IntegerProperty entranceHourProperty() {
        return entranceHour;
    }

    @JsonProperty("exitHour")
    public int getExitHour() {
        return exitHour.get();
    }

    @JsonProperty("exitHour")
    public void setExitHour(int exitHour) {
        this.exitHour.set(exitHour);
    }

    @SuppressWarnings("exports")
    public IntegerProperty exitHourProperty() {
        return exitHour;
    }

    @JsonProperty("date")
    public LocalDate getDate() {
        return date.get();
    }

    @JsonProperty("date")
    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }
}