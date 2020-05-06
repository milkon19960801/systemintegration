package Modules;

import java.time.LocalDate;
import java.util.HashMap;

public class WeeklyReport {
    private LocalDate date = LocalDate.now();
    private HashMap<LocalDate, Float> map = new HashMap<>();

    private double avrage;

    public WeeklyReport() { }
    public WeeklyReport(HashMap<LocalDate, Float> map, double avrage) {
        this.map = map;
        this.avrage = avrage;
    }

    public LocalDate getDate() { return date; }
    public double getAvrage() { return avrage; }
    public HashMap<LocalDate, Float> getMap() { return map; }

    public void setDate(LocalDate date) { this.date = date; }
    public void setMap(HashMap<LocalDate, Float> map) { this.map = map; }
    public void setAvrage(double avrage) { this.avrage = avrage; }
}
