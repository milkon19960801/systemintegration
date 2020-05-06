package Package.Util;

import java.time.LocalDate;

public class Temperature {
    int id;
    float temperature;
    LocalDate date;

    public Temperature(int id, float temperature, LocalDate date) {
        this.id = id;
        this.temperature = temperature;
        this.date = date;
    }
    public Temperature() { }


    public int getId() { return id; }
    public float getTemperature() { return temperature; }
    public LocalDate getDate() { return date; }

    public void setId(int id) { this.id = id; }
    public void setTemperature(float temperature) { this.temperature = temperature; }
    public void setDate(LocalDate date) { this.date = date; }
}
