package es1.object;

import java.io.Serializable;

public class Message implements Serializable {

    private float temperature;

    public Message(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

}