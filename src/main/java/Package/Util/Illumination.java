package Package.Util;

import java.time.LocalDate;

public class Illumination {
    int id;
    int illumination;
    LocalDate date;

    public Illumination(int id, int illumination, LocalDate date) {
        this.id = id;
        this.illumination = illumination;
        this.date = date;
    }
    public Illumination() { }

    public int getId() { return id; }
    public int getIllumination() { return illumination; }
    public LocalDate getDate() { return date; }

    public void setId(int id) { this.id = id; }
    public void setIllumination(int illumination) { this.illumination = illumination; }
    public void setDate(LocalDate date) { this.date = date; }
}
