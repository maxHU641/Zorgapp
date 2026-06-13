import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Patient {

    /// Patient data
    int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private double height;
    private double weight;
    private String gender;
    private String comments;

    private List<Medication> medications = new ArrayList<>();
    private List<Consult> consults = new ArrayList<>();
    private List<Tests>  tests = new ArrayList<>();


    Patient(int id, String firstName, String lastName,
            LocalDate dateOfBirth, double height,
            double weight, String gender, String comments) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.comments = comments;
    }

    /// Display patient data.
    void viewData(User currentUser) {
        System.out.println(" "); // whitespace for readability
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.format("===== Patient id (%d) ==============================\n", id);
        System.out.format("%-17s %s\n", "First name:", firstName);
        System.out.format("%-17s %s\n", "Last name:", lastName);
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth.format(formatter));
        System.out.format("%-17s %s\n", "Age:", age());
        System.out.format("%-17s %s\n", "Gender:", gender);
        System.out.format("%-17s %s\n", "Height (in cm):", height);
        System.out.format("%-17s %s\n", "Weight (in kg):", weight);
        System.out.format("%-17s %s\n", "BMI:", calculateBMI());

        // Vital functions
        System.out.println(" "); // whitespace
        System.out.println("----- Tested vitals functions -----");
        if (tests.isEmpty()) {
            System.out.println("No tests done");
        } else {
            for (Tests tes : tests) {
                System.out.println(tes);
            }
        }

        // medication
        System.out.println(" "); // whitespace
        System.out.println("----- Medication -----");
        if (currentUser.getCantViewMedication()) {
            System.out.println("You are not allowed to view medication.");
        } else if (currentUser.getCanOnlyViewNarcoticMedication()) {
            boolean hasNarcotic = false;
            for (Medication med : medications) {
                if (med.getNarcotic()) {
                    System.out.println(med);
                    hasNarcotic = true;
                }
            }
            if (!hasNarcotic) {
                System.out.println("No medication available");
            }
        } else {
            if (medications.isEmpty()) {
                System.out.println("Patient doesn't take any medication");
            } else {
                for (Medication med : medications) {
                    System.out.println(med);
                }
            }
        }

        // consults
        System.out.println(" ");
        System.out.println("----- Consultations -----");


        if (currentUser.getCantSeeConsults()) {
            System.out.println("You are not allowed to see consultations.");
        }
        else if (consults.isEmpty()) {
            System.out.println("No consultations found");
        } else {
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.println("- Past consultations:");
            boolean hasPast = false;
            for (Consult con : consults) {
                LocalDate consultDate = con.getDate();
                if (consultDate.isBefore(LocalDate.now())) {
                    System.out.println(con.getDate().format(formatter2) + " | " + con.getType());
                    hasPast = true;
                }
            }
            if (!hasPast) {
                System.out.println("None");
            }

            System.out.println(" ");
            System.out.println("- Planned consultations:");
            boolean hasPlanned = false;
            for (Consult con : consults) {
                LocalDate consultDate = con.getDate();
                if (consultDate.isAfter(LocalDate.now()) || consultDate.equals(LocalDate.now())) {
                    System.out.println(con.getDate().format(formatter) + " | " + con.getType());
                    hasPlanned = true;
                }
            }
            if (!hasPlanned) {
                System.out.println("None");
            }
        }

        // comments
        System.out.println(" ");
        System.out.println("----- Comments -----");
        if(comments == null) {
            System.out.println("No comments");
        } else {
            System.out.println(comments);
        }
    }


    /// methods
    // Toevoegen aan lijsten
    public void addMedication(Medication med) {
        medications.add(med);
    }
    public List<Medication> getMedications() {
        return medications;
    }

    public void addConsult(Consult consult) {
        consults.add(consult);
    }
    public List<Consult> getConsults() {
        return consults;
    }

    public void addTests(Tests tes) {
        tests.add(tes);
    }
    public List<Tests> getTests() {
        return tests;
    }

    //BMI calculator
    double calculateBMI() {
        double newHeight = height / 100;
        return Math.round(weight / (newHeight * newHeight) * 100.0) / 100.0;
    }

    //age calculator
    int age() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }



    ///  Getters en Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getcomments() {
        return comments;
    }
    public void setcomments(String comments) {
        this.comments = comments;
    }
}