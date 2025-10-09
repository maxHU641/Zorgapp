import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consult {

    /// variabelen
    private LocalDate date;
    private String type;
    //private String notes;

    /// constructor
    public Consult(LocalDate date, String type, String notes) {
        this.date = date;
        this.type = type;
    }

    /// data formatter
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter) + " - " + type + " " + "\n" + "Notes: ";
    }

    /// getters en setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
    }
}

