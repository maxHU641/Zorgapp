public class Tests {

    /// variabelen
    private String bloodPressure;
    private String lungCapacity;

    /// constructor
    public Tests(String bloodPressure, String lungCapacity) {
        this.bloodPressure = bloodPressure;
        this.lungCapacity = lungCapacity;
    }

    /// formatter
    public String toString() {
        return "Bloodpressure: " + bloodPressure + "mmHg" + "\nLungcapacity: " + lungCapacity + "L";
    }

    /// getters en setters
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }

    public String getLungCapacity() { return lungCapacity; }
    public void setLungCapacity(String lungCapacity) { this.lungCapacity = lungCapacity; }
}
