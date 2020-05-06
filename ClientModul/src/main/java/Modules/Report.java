package Modules;

import java.time.LocalDate;
import java.util.HashMap;

public class Report {
    float humidity;
    float temperature;
    int electricity ;
    int illumination;
    LocalDate date;
    HashMap<LocalDate, Float> map = new HashMap<>();

    double avrage;

    public Report(float humidity, float temperature, int illumination, LocalDate date) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.illumination = illumination;
        this.date = date;
    }
    public Report(HashMap<LocalDate, Float> map, double avrage) {
        this.map = map;
        this.avrage = avrage;
    }
    public Report() { }


    public float getHumidity() { return humidity; }
    public float getTemperature() { return temperature; }
    public int getElectricity() { return electricity; }
    public int getIllumination() { return illumination; }
    public LocalDate getDate() { return date; }
    public double getAvrage() { return avrage; }
    public HashMap<LocalDate, Float> getMap() { return map; }


    public void setHumidity(float humidity) { this.humidity = humidity; }
    public void setTemperature(float temperature) { this.temperature = temperature; }
    public void setElectricity(int electricity) { this.electricity = electricity; }
    public void setIllumination(int illumination) { this.illumination = illumination; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setAvrage(double avrage) { this.avrage = avrage; }
    public void setMap(HashMap<LocalDate, Float> map) { this.map = map; }
}
