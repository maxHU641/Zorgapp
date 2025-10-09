public class Medication {


    /// variabelen
    private String medication;
    private String dosage;
    private String comments;
    private boolean narcotic;


    /// constructor
    public Medication(String medication, String dosage, String comments, boolean narcotic) {
        this.medication = medication;
        this.dosage = dosage;
        this.comments = comments;
        this.narcotic = narcotic;
    }


    /// data formatter
    public String toString() {
        return medication + " (" + dosage + ") - " + comments;
    }


    /// getters & setters
    public String getName() { return medication; }
    public void setName(String name) { this.medication = name; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getComments() { return comments; }
    public void setComments(String notes) { this.comments = comments; }

    public boolean getNarcotic() { return narcotic; }
    public void setNarcotic(boolean narcotic) {
        this.narcotic = narcotic;
    }
}

