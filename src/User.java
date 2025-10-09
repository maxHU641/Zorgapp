class User {

    /// variabelen
    private int userID;
    private String userName;
    private String userRole;
    private boolean cantViewMedication;
    private boolean canOnlyViewNarcoticMedication;
    private boolean cantEditMedication;
    private boolean cantSeeConsults;
    private boolean cantCreatePatients;


    /// constructor
    public User(int id, String name, String role) {
        this.userID = id;
        this.userName = name;
        this.userRole = role;
    }


    /// getters
    public int getUserID() { return userID; }
    public String getUserName() { return userName; }
    public String getUserRole() { return userRole; }


    public boolean getCantViewMedication() {
        return cantViewMedication;
    }
    public boolean getCanOnlyViewNarcoticMedication() {
        return canOnlyViewNarcoticMedication;
    }
    public boolean getCantEditMedication() {
        return cantEditMedication;
    }
    public boolean getCantSeeConsults() {
        return cantSeeConsults;
    }
    public boolean getCantCreatePatients() {
        return cantCreatePatients;
    }



    public void setCantViewMedication(boolean cantViewMedication) {
        this.cantViewMedication = cantViewMedication;
    }
    public void setCanOnlyViewNarcoticMedication(boolean canOnlyViewNarcoticMedication) {
        this.canOnlyViewNarcoticMedication = canOnlyViewNarcoticMedication;
    }
    public void setCantEditMedication (boolean cantEditMedication) {
        this.cantEditMedication = cantEditMedication;
    }
    public void setCantSeeConsults(boolean cantSeeConsults) {
        this.cantSeeConsults = cantSeeConsults;
    }
    public void setCantCreatePatients(boolean cantCreatePatients) {
        this.cantCreatePatients = cantCreatePatients;
    }
}


/// users
//huisarts
class Huisarts extends User {
    public Huisarts(int id, String name) {
        super(id, name, "Huisarts");
    }
}

// tandarts
class Tandarts extends User {
    public Tandarts(int id, String name) {
        super(id, name, "Tandarts");
        setCanOnlyViewNarcoticMedication(true);
    }
}

// fysiotherapeut
class Fysiotherapeut extends User {
    public Fysiotherapeut(int id, String name) {
        super(id, name, "Fysiotherapeut");
        setCantViewMedication(true);
        setCantEditMedication(true);
    }
}

// apotheker
class Apotheker extends User {
    public Apotheker(int id, String name) {
        super(id, name, "Apotheker");
        setCantEditMedication(true);
        setCantSeeConsults(true);
        setCantCreatePatients(true);
    }
}

