package Package.Util;

import java.time.LocalDate;

public class Electricity {
    int id;
    int electricity;
    LocalDate date;

    public Electricity() { }

    public Electricity(int id, int electricity, LocalDate date) {
        this.id = id;
        this.electricity = electricity;
        this.date = date;
    }

    public int getId() { return id; }
    public int getElectricity() { return electricity; }
    public LocalDate getDate() { return date; }

    public void setId(int id) { this.id = id; }
    public void setElectricity(int electricity) { this.electricity = electricity; }
    public void setDate(LocalDate date) { this.date = date; }
}
