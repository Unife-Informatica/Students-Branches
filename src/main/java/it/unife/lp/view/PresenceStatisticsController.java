package it.unife.lp.view;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import it.unife.lp.model.Person;
import it.unife.lp.model.Presence;

import java.util.List;

public class PresenceStatisticsController {

    @FXML
    private BarChart<String, Number> barChart;

    private List<Person> personData;

    @FXML
    private void initialize() {
        // Inizializza il grafico
    }

    public void setPersonData(List<Person> personData) {
        this.personData = personData;
        updateBarChart();
    }

    private void updateBarChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Presenze");

        int[] hourCounter = new int[24];
        for (Person person : personData) {
            for (Presence presence : person.getPresenze()) {
                int entranceHour = presence.getEntranceHour();
                int exitHour = presence.getExitHour();
                for (int i = entranceHour; i < exitHour; i++) {
                    hourCounter[i]++;
                }
            }
        }

        for (int i = 0; i < hourCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(i), hourCounter[i]));
        }

        barChart.getData().clear();
        barChart.getData().add(series);
    }
}