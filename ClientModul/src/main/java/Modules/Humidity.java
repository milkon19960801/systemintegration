package Modules;

import java.time.LocalDate;

public class Humidity {
    int id;
    float humidity;
    LocalDate date;

    public Humidity(int id, float humidity, LocalDate date) {
        this.id = id;
        this.humidity = humidity;
        this.date = date;
    }
    public Humidity() { }

    public int getId() { return id; }
    public float getHumidity() { return humidity; }
    public LocalDate getDate() { return date; }



    public void setId(int id) { this.id = id; }
    public void setHumidity(float humidity) { this.humidity = humidity; }
    public void setDate(LocalDate date) { this.date = date; }
}
