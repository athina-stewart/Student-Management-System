import java.util.Arrays;

public class StudentRecord {

    private String name;
    private int grade;
    private int schoolID;
    private String emergencyContactName;
    private int emergencyContactNumber;
    private String[] allergies = new String[20];

    public StudentRecord(){}

    public StudentRecord(String name, int grade, int schoolID){
        this.name = name;
        this.grade = grade;
        this.schoolID = schoolID;
        this.emergencyContactNumber = 0;
        this.emergencyContactName = null;
        this.allergies[0] = "null";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public int getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(int emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    public String toString(){
        return("Record: Name[ " + name + " ], ID[ " + schoolID +" ], Grade[ "
                + grade + " ], Allergies[ " + Arrays.toString(allergies) + " ]," +
                " Contact Name[ " + emergencyContactName + " ], Contact Number" +
                "[ " + emergencyContactNumber + " ]");
    }
}
